package com.example.sureshreddy.barclays.common;



public class StringUtil {

    public static String getValidString(String str){
        if(str != null && str.length() > 0){
            str = str.trim();
            str = str.replaceAll(" ","_");
        }
        return str;
    }
}
