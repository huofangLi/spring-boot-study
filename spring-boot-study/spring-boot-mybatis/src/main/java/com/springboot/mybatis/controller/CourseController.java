package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.service.CourseService;
import com.springboot.mybatis.util.RandomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class CourseController {
    @Resource
    private CourseService courseService;

    /*查——全部*/
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> selectAll() {
        return courseService.selectAll();
    }

    /*查——自定的ID*/
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Course getOne(@PathVariable("id") long id) {
        return courseService.getOne(id);
    }

    /*删*/
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.delete(id);
    }

    /*增*/
    @RequestMapping(value = "courses", method = RequestMethod.POST)
    @ResponseBody
    public Course addCourse(@RequestBody Course course) {
        course.setCourseCode(RandomUtil.getRandomCode());
        return courseService.insert(course);
        /*{
            "courseId": 23,
                "courseName": "测试课程123123",
                "userId": 2,
                "courseClass": "软件1731",
                "cover": "1.jpg",
                "courseCode": "628836",
                "finished": 0
        }*/
    }

    /*改*/
    @RequestMapping(value = "/courses", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        courseService.update(course);
    }
}