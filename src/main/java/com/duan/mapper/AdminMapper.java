package com.duan.mapper;

import com.duan.pojo.Admin;
import com.duan.pojo.TableDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {
    @Select("select * from manager where username=#{userName} and password=#{password}")
    Admin select(@Param("userName") String userName, @Param("password") String password);
}
