package com.duan.handler;

import com.duan.pojo.Student;
import com.duan.service.StudentService;
import com.duan.service.impl.StudentServiceImpl;
import com.duan.view.AddStudentView;
import com.duan.view.MainView;
import com.duan.view.UpdateStudentView;
import org.apache.ibatis.annotations.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateViewHandle implements ActionListener {
    //将窗口类加入成员变量来获取窗口中的按钮。
    private UpdateStudentView updateStudentView;
    private MainView mainView;
    public UpdateViewHandle(UpdateStudentView updateStudentView, MainView mainView){
        this.updateStudentView=updateStudentView;
        this.mainView=mainView;
    }
    //事件主要逻辑。
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("修改".equals(text)) {
            StudentService service = new StudentServiceImpl();
            Student student=updateStudentView.builtUpdatedStudent();
            boolean flag = service.updateStudent(student);
            if(flag){
                JOptionPane.showMessageDialog(updateStudentView,"修改成功");
                mainView.SelectByPage();
                updateStudentView.dispose();
            }else {
                JOptionPane.showMessageDialog(updateStudentView,"修改失败");
            }
        }
    }
}