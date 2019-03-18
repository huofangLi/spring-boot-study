package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.SysUser;
import com.springboot.mybatis.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    /*查——全部*/
    @RequestMapping(value = "/sysUser", method = RequestMethod.GET)
    public List<SysUser> selectAll() {
        return sysUserService.selectAll();
    }

    /*查——自定的ID*/
    @RequestMapping(value = "/sysUser/{id}", method = RequestMethod.GET)
    public SysUser getOne(@PathVariable("id") long id) {
        return sysUserService.getOne(id);
    }

    /*删*/
    @RequestMapping(value = "/sysUser/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") long id) {
        sysUserService.delete(id);
    }

    /*增*/
    @RequestMapping(value = "/sysUser", method = RequestMethod.POST)
    public SysUser addCourse(@RequestBody SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }

    /*改*/
    @RequestMapping(value = "/sysUser", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
    }
}
