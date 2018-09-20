package com.hftang.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * s source 源
 * t target 目标
 *
 * springmvc 的转换器
 */

public class CustomGlobalStrToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(s);

            return date;


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
