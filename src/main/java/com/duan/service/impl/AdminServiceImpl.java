package com.duan.service.impl;

import com.duan.Utill.SqlSessionFactoryUtils;
import com.duan.mapper.AdminMapper;
import com.duan.pojo.Admin;
import com.duan.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean Login(String userName,String password) {
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        Admin admin = mapper.select(userName, password);
        return admin!=null;
    }
}
