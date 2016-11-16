package com.example.barclaysinterviewproject.common;

/**
 * Created by DrakeBoltz on 11/14/2016.
 */

public class StringUtil {

    public static String getValidString(String str){
        if(str != null && str.length() > 0){
            str = str.trim();
            str = str.replaceAll(" ","_");
        }
        return str;
    }
}
