package com.duan.Utill;

import java.awt.*;

/**
 * 获取整个屏幕大小
 */
public class DimensionUtil {
    public static Dimension getBound(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }
}
