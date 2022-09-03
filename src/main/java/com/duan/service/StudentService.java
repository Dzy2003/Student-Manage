package com.duan.service;

import com.duan.pojo.Student;
import com.duan.pojo.StudentRequest;
import com.duan.pojo.TableDTO;

public interface StudentService {
    //查询数据库学生成绩信息
    TableDTO selectStudents(StudentRequest request);
    TableDTO searchByName(StudentRequest request,String name);
    Boolean AddStudent(Student student);
    Student selectById(int id);
    boolean updateStudent(Student student);
    boolean deleteByIds(int[] ids);
}
