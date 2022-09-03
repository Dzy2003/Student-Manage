package com.duan.handler;

import com.duan.service.StudentService;
import com.duan.service.impl.StudentServiceImpl;
import com.duan.view.AddStudentView;
import com.duan.view.MainView;
import com.duan.view.UpdateStudentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewHandle implements ActionListener {
    //将窗口类加入成员变量来获取窗口中的按钮。
    private MainView mainView;
    public MainViewHandle(MainView mainView){
        this.mainView=mainView;
    }
    //事件主要逻辑。
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("添加".equals(text)) {
            new AddStudentView(mainView);
        }else if("修改".equals(text)){
            //一次修改一条数据
            //获取选中的id
            int[] ids = mainView.getSelectedIds();
            if (ids.length!=1){
                JOptionPane.showMessageDialog(mainView,"一次只能修改一条数据");
                return;
            }else {
                new UpdateStudentView(mainView, ids[0]);
            }

        }else if("删除".equals(text)){
            int[] ids = mainView.getSelectedIds();
            if (ids.length>0){
                int option = JOptionPane.showConfirmDialog(mainView, "确认要删除选中行的" + ids.length + "行吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                //确认删除返回
                if (option==JOptionPane.YES_OPTION){
                    //删除
                    StudentService studentService = new StudentServiceImpl();
                    boolean flag = studentService.deleteByIds(ids);
                    if (flag){
                        JOptionPane.showMessageDialog(mainView,"删除成功");
                        mainView.SelectByPage();
                    }else {
                        JOptionPane.showMessageDialog(mainView,"删除失败");
                    }
                }
            }else {
                JOptionPane.showMessageDialog(mainView,"请至少选择一行");
            }

        }else if("查询".equals(text)){
            mainView.setCurPage(1);
            mainView.SearchByName();
        }else if("上一页".equals(text)){
            mainView.setCurPage(mainView.getCurPage()-1);
            mainView.SelectByPage();
        }else if("下一页".equals(text)){
            mainView.setCurPage(mainView.getCurPage()+1);
            mainView.SelectByPage();
        }
    }
}