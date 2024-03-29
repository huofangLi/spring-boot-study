package com.springboot.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*上传文件控制器
 *直接上传到控制器
 */

@RestController
public class UploadController {
    //这是顶一个临时路径作为上传目录
//    private static String UPLOAD_FOLDER = "E:/SpringBootStudy/temp/";

    //遇到http://localhost:8080,则跳到upload.haml页面
//    @GetMapping("/")
//    public String index() {
//        return "upload";
//    }

//    @GetMapping("/hello")
//    public String index1() {
//        return "hello";
//    }

    //上传文件需要注解@RequestParam
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile srcFile, RedirectAttributes redirectAttributes) {
        String returnFileName = "";
        //前端没有选择文件，srcFile为空
        if (srcFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择一个文件");
            return "redirect:upload_status";
        }
        //选择了文件，开始进行上传操作
        try {
//            构建上传目标路径,找到了项目的targetde classes目录
            File destFile = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!destFile.exists()) {
                destFile = new File("");
            }
//            输出目标文件的绝对路径
            System.out.println("file path:" + destFile.getAbsolutePath());
//            拼接static目录

//           获取时间
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
            String time = df.format(new Date());// new Date()为获取当前系统时间

            File upload = new File(destFile.getAbsolutePath(), "static/" + time);
//            若目标文件夹不存在，则创建一个
            if (!upload.exists()) {
                upload.mkdirs();
            }

            System.out.println("完整的上传路径：" + upload.getAbsolutePath() + "/" + srcFile.getOriginalFilename());

            //根据srcFile的大小准备一个字节数组
            byte[] bytes = srcFile.getBytes();

//            拼接上传路径
//            Path path = Paths.get(UPLOAD_FOLDER + srcFile.getOriginalFilename());


            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
// 获得文件原始名称
            String fileName = srcFile.getOriginalFilename();
// 获得文件后缀名称
            String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
// 生成最新的uuid文件名称
            String newFileName = uuid + "." + suffixName;

            //           通过项目路径拼接上传路径
            Path path = Paths.get(upload.getAbsolutePath() + "/" + newFileName);

            //最重要的一步，将源文件写入目标地址!!!
            Files.write(path, bytes);

            //将文件上传成功的信息写入messages
            redirectAttributes.addFlashAttribute("message", "文件上传成功" + newFileName);
            returnFileName = "http://localhost:8080/upload/" + newFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnFileName;
    }

    //匹配upload_status页面
    @GetMapping("/upload_status")
    public String uploadStatusPage() {
        return "upload_status";
    }
}
