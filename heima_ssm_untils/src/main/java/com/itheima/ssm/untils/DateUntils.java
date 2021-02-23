package com.itheima.ssm.untils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntils {

    //日期转化成字符串
    public static String DateToString (Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    //字符串转化成日期
    public static Date StringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;

    }
}
