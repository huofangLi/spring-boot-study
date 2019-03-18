package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysUserMapper {
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "username", column = "username"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT * FROM t_sys_user ")
    List<SysUser> selectAll();

    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "username", column = "username"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT * FROM t_sys_user WHERE user_id = #{userId}")
    SysUser getOne(Long userId);

    /*删除*/
    @Delete("DELETE FROM t_sys_user WHERE user_id = #{user_id} ")
    void delete(Long userId);

    /*插入*/
    @Insert("INSERT INTO t_sys_user(mobile,password,username,avatar) " +
            "VALUES(#{mobile},#{password},#{username},#{avatar})")
    void insert(SysUser sysUser);

    /*修改*/
    @Update("UPDATE t_sys_user SET mobile=#{mobile},password=#{password},username=#{username},avatar=#{avatar} WHERE user_id =#{userId}")
    void update(SysUser sysUser);
}