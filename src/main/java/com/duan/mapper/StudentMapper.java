package com.duan.mapper;

import com.duan.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //分页查询
    @Select("select * from student limit #{begin},#{end}")
    @ResultMap("StudentResultMap")
    List<Student> SelectByPage(@Param("begin") int begin, @Param("end") int end);
    //查询数据数量
    @Select("SELECT count(*) from student")
    int SelectTotalCount();
    //分页搜索查询
    @ResultMap("StudentResultMap")
    @Select("select * from student where name like #{name} limit #{begin},#{end}")
    List<Student> searchByName(@Param("begin") int begin, @Param("end") int end,@Param("name") String name);
    //获取分页搜索结果数量
    @Select("select count(*) from student where name like #{name}")
    int searchByNameCount(@Param("name") String name);
    //添加数据
    @ResultMap("StudentResultMap")
    @Insert("insert into student values (null,#{name},#{no},#{homeTown},#{cnScore},#{enScore},#{mathScore})")
    int AddStudent(Student student);
    //id查询数据
    @ResultMap("StudentResultMap")
    @Select("select * from student where id=#{id}")
    Student selectById(int id);
    //修改数据
    @ResultMap("StudentResultMap")
    @Update("update student set name=#{name},no=#{no}" +
            ",home_town=#{homeTown},cn_score=#{cnScore},en_score=#{enScore},math_score=#{mathScore} where id=#{id}")
    int UpdateStudent(Student student);
    //多行删除
    int deleteByIds(int[] ids);


}
