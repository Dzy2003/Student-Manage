package com.duan.handler;

import com.duan.pojo.Student;
import com.duan.service.StudentService;
import com.duan.service.impl.StudentServiceImpl;
import com.duan.view.AddStudentView;
import com.duan.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddViewHandle implements ActionListener {
    //将窗口类加入成员变量来获取窗口中的按钮。
    private AddStudentView addStudentView;
    private MainView mainView;
    public AddViewHandle(AddStudentView addStudentView, MainView mainView){
        this.addStudentView=addStudentView;
    }
    //事件主要逻辑。
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("添加".equals(text)) {
            mainView=new MainView();
            Student student = addStudentView.StudentBuilt();
            StudentService studentService = new StudentServiceImpl();
            Boolean flag = studentService.AddStudent(student);
            if(flag){
                JOptionPane.showMessageDialog(addStudentView,"添加成功");
                mainView.SelectByPageNow();
                addStudentView.dispose();
            }else {
                JOptionPane.showMessageDialog(addStudentView,"添加失败");
            }
        }
    }
}