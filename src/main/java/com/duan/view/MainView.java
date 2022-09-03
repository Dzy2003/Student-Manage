package com.duan.view;

import com.duan.Utill.DimensionUtil;
import com.duan.handler.LoginHandle;
import com.duan.handler.MainViewHandle;
import com.duan.pojo.Student;
import com.duan.pojo.StudentRequest;
import com.duan.pojo.TableDTO;
import com.duan.service.StudentService;
import com.duan.service.impl.StudentServiceImpl;
import com.duan.view.ext.MainViewTable;
import com.duan.view.ext.MainViewTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * 主界面窗口
 */
public class MainView extends JFrame {
    //添加组件
    //默认流式布局,界面北边布局
    JPanel northPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton addBtn=new JButton("添加");
    JButton updateBtn=new JButton("修改");
    JButton delBtn=new JButton("删除");
    JTextField searchTxt=new JTextField(15);
    JButton searchBtn=new JButton("查询");
    //默认流式布局，界面南边布局
    JPanel southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton preBtn=new JButton("上一页");
    JButton nextBtn=new JButton("下一页");
    private int curPage=1; //当前页数
    private int pageSize=5;
    MainViewHandle mainViewHandle=new MainViewHandle(this);


    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    MainViewTable mainViewTable=new MainViewTable();

    public MainView(){
        super("学生管理系统主界面");
        Dimension bound = DimensionUtil.getBound();
        //初始化组件
        Container contentPane = getContentPane();
        //将组件添加到北边，调用方法
        layoutNorth(contentPane);
        //设置中间的表格
        layoutCenter(contentPane);
        //将组件添加到南边，调用方法。
        layoutSouth(contentPane);

        //初始化窗口，根据屏幕大小获取主界面大小。
        setSize(bound);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void layoutCenter(Container contentPane) {
        MainViewTableModel mainViewTableModel = SelectByPage();
        mainViewTable.setDataModel(mainViewTableModel);
        //表格渲染方式
        mainViewTable.renderRule();
        //实例化表格
        JScrollPane jScrollPane=new JScrollPane(mainViewTable);
        contentPane.add(jScrollPane,BorderLayout.CENTER);
    }



    //自定义函数添加界面南边
    private void layoutSouth(Container contentPane ) {
        southPanel.add(preBtn);
        southPanel.add(nextBtn);
        contentPane.add(southPanel,BorderLayout.SOUTH);
    }
    //自定义函数添加右边
    private void layoutNorth(Container contentPane) {
        //增加事件监听
        addBtn.addActionListener(mainViewHandle);
        preBtn.addActionListener(mainViewHandle);
        nextBtn.addActionListener(mainViewHandle);
        searchBtn.addActionListener(mainViewHandle);
        delBtn.addActionListener(mainViewHandle);
        updateBtn.addActionListener(mainViewHandle);


        northPanel.add(addBtn);
        northPanel.add(updateBtn);
        northPanel.add(delBtn);
        northPanel.add(searchBtn);
        northPanel.add(searchTxt);
        contentPane.add(northPanel,BorderLayout.NORTH);
    }
    public MainViewTableModel SelectByPage() {
        StudentService service = new StudentServiceImpl();
        StudentRequest request = new StudentRequest();
        request.setPageNow(curPage);
        request.setPageSize(pageSize);
        TableDTO dto = service.selectStudents(request);
        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(dto.getData());
        mainViewTable.setDataModel(mainViewTableModel);
        //表格渲染方式
        mainViewTable.renderRule();
        return mainViewTableModel;
    }
    public MainViewTableModel SearchByName() {
        StudentService service = new StudentServiceImpl();
        StudentRequest request = new StudentRequest();
        request.setPageNow(curPage);
        request.setPageSize(pageSize);
        String text = searchTxt.getText();
        //模糊查询
        text="%"+text+"%";
        TableDTO dto = service.searchByName(request,text);
        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(dto.getData());
        mainViewTable.setDataModel(mainViewTableModel);
        //表格渲染方式
        mainViewTable.renderRule();
        return mainViewTableModel;
    }
    public int[] getSelectedIds(){
        int[] rows = mainViewTable.getSelectedRows();
        int[] ids=new int[rows.length];
        for (int i = 0; i < rows.length; i++) {
            int rowIndex=rows[i];
            Object idObj = mainViewTable.getValueAt(rowIndex, 0);
            ids[i]=Integer.valueOf(idObj.toString());
        }
        return ids;
    }
    public static void main(String[] args) {
        new MainView();
    }
}
