package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.SysUser;
import java.util.List;

public interface SysUserService {
    List<SysUser> selectAll();

    SysUser getOne(Long userId);

    void delete(Long userId);

    SysUser insert(SysUser sysUser);

    void update(SysUser sysUser);
}
