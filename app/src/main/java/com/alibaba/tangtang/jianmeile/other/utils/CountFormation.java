package com.alibaba.tangtang.jianmeile.other.utils;

import java.text.DecimalFormat;

/**
 * 输入一个int类型整数，得到一个字符串
 * eg:1000   1,000
 *
 * Created by zhaoaiqiu on 2016/6/30.
 */
public class CountFormation{
    public static String getStringFomat(int count){

        if(count<1000){
            return count+"";
        }else {
            DecimalFormat df = new DecimalFormat("#,###");
            String format = df.format(count);
            return format;
        }
    }

    /**
     * 传入一个字符串数据类型
     * 输出一个精度两位的小数
     * @param count
     * @return
     */
    public static String getStringFomat1(String count){
        double parseDouble = Double.parseDouble(count)/1000;
        DecimalFormat format = new DecimalFormat("#.00");
        String format1 = format.format(parseDouble);
        return format1;
    }
}
