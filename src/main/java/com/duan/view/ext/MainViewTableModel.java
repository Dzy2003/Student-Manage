package com.duan.view.ext;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MainViewTableModel extends DefaultTableModel {
    static Vector<String> columns=new Vector<>();
    static {
        columns.addElement("编号");
        columns.addElement("姓名");
        columns.addElement("学号");
        columns.addElement("家乡");
        columns.addElement("语文");
        columns.addElement("数学");
        columns.addElement("英语");
        columns.addElement("总分");
    }
    private MainViewTableModel(){
        super(null,columns);
    }
    private static MainViewTableModel studentTableModel=new MainViewTableModel();
    public static MainViewTableModel assembleModel(Vector<Vector<Object>> data){
        studentTableModel.setDataVector(data,columns);
        return studentTableModel;
    }
    public static Vector<String> getColumns(){
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
