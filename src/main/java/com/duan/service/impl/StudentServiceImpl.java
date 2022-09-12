package com.duan.service.impl;

import com.duan.Utill.SqlSessionFactoryUtils;
import com.duan.mapper.StudentMapper;
import com.duan.pojo.Student;
import com.duan.pojo.StudentRequest;
import com.duan.pojo.TableDTO;
import com.duan.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class StudentServiceImpl implements StudentService {
    SqlSessionFactory sessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有学生
     * @param request
     * @return
     */
    @Override
    public TableDTO selectStudents(StudentRequest request) {

        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int pageNow = request.getPageNow();
        int pageSize = request.getPageSize();
        int begin=(pageNow-1)*pageSize;
        int end=pageSize;
        List<Student> students = mapper.SelectByPage(begin,end);
        int totalCount = mapper.SelectTotalCount();
        Vector<Vector<Object>> data=new Vector<>();
        TableDTO dto = new TableDTO();
        //遍历数组对象为data赋值。
        for (int i=0;i<students.size();i++) {
            Vector<Object> oneRecord=new Vector<>();
            oneRecord.addElement(students.get(i).getId());
            oneRecord.addElement(students.get(i).getName());
            oneRecord.addElement(students.get(i).getNo());
            oneRecord.addElement(students.get(i).getHomeTown());
            oneRecord.addElement(students.get(i).getCnScore());
            oneRecord.addElement(students.get(i).getEnScore());
            oneRecord.addElement(students.get(i).getMathScore());
            oneRecord.addElement(students.get(i).getEnScore()+students.get(i).getCnScore()+students.get(i).getMathScore());
            data.addElement(oneRecord);
        }
        dto.setData(data);
        dto.setTotalCount(totalCount);
        session.close();
        return dto;
    }

    /**
     * 通过名字查找
     * @param request
     * @param name
     * @return
     */

    @Override
    public TableDTO searchByName(StudentRequest request,String name) {
        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int pageNow = request.getPageNow();
        int pageSize = request.getPageSize();
        int begin=(pageNow-1)*pageSize;
        int end=pageSize;
        List<Student> students = mapper.searchByName(begin,end,name);
        int totalCount = mapper.searchByNameCount(name);
        Vector<Vector<Object>> data=new Vector<>();
        TableDTO dto = new TableDTO();
        //遍历数组对象为data赋值。
        for (int i=0;i<students.size();i++) {
            Vector<Object> oneRecord=new Vector<>();
            oneRecord.addElement(students.get(i).getId());
            oneRecord.addElement(students.get(i).getName());
            oneRecord.addElement(students.get(i).getNo());
            oneRecord.addElement(students.get(i).getHomeTown());
            oneRecord.addElement(students.get(i).getCnScore());
            oneRecord.addElement(students.get(i).getEnScore());
            oneRecord.addElement(students.get(i).getMathScore());
            oneRecord.addElement(students.get(i).getEnScore()+students.get(i).getCnScore()+students.get(i).getMathScore());
            data.addElement(oneRecord);
        }
        dto.setData(data);
        dto.setTotalCount(totalCount);
        session.close();
        return dto;
    }

    @Override
    public Boolean AddStudent(Student student) {
        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int i = mapper.AddStudent(student);
        session.commit();
        session.close();
        return i==1;
    }

    @Override
    public Student selectById(int id) {
        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectById(id);
        return student;
    }

    @Override
    public boolean updateStudent(Student student) {
        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int i = mapper.UpdateStudent(student);
        session.commit();
        session.close();
        return i==1;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        SqlSession sqlSession = sessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
        return i==ids.length;
    }
}
