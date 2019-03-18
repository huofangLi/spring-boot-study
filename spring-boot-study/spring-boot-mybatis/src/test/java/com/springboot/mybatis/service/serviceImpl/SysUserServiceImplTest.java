package com.springboot.mybatis.service.serviceImpl;

import com.springboot.mybatis.entity.SysUser;
import com.springboot.mybatis.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {
    @Resource
    private SysUserService sysUserService;

    @Test
    public void selectAll() {
        List<SysUser> sysUserList = sysUserService.selectAll();
        sysUserList.forEach(sysUser -> System.out.println(sysUser));
    }

    @Test
    public void getOne() {
        SysUser sysUser = sysUserService.getOne(1L);
        System.out.println(sysUser);
    }

    @Test
    public void delete() {
        sysUserService.delete(4L);
    }

    @Test
    public void insert() {
        SysUser sysUser = new SysUser();
        sysUser.setMobile("17805116188");
        sysUser.setPassword("123654");
        sysUser.setUsername("王德旺");
        sysUser.setAvatar(" 1.jpg");
        sysUserService.insert(sysUser);
    }

    @Test
    public void update() {
        SysUser sysUser = sysUserService.getOne(5L);
        sysUser.setMobile("17805116178");
        sysUser.setPassword("123644");
        sysUser.setUsername("王旺");
        sysUser.setAvatar(" 2.jpg");
        sysUserService.update(sysUser);
    }
}