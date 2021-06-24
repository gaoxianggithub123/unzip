package com.gaoxiang.unziptest.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO
 *
 * @author gaoxiang
 * @date 2021/5/2912:50
 */
public class UnZipTest {
    public static void main(String[] args) {
        File[] ls = FileUtil.ls("C:\\Users\\GaoX\\Desktop\\一");
        List<String> unzip = unzip(ls);
        for (String s:unzip) {
            System.out.println(s);
        }
    }

    public static List<String> unzip(File[] ls){
        List<String> list = new ArrayList<>();
        for(File f:ls){
            String titile = FileUtil.getName(f);
            if(titile.contains(".txt")){
                String content = FileUtil.readString(f, Charset.defaultCharset());
                String submit = submit(titile, content);
                list.add(submit);
            }else{
                File[] files = f.listFiles();
                unzip(files).forEach((fs)->{
                    list.add(fs);
                });
            }
        }
        return list;
    }

    static String submit(String s1,String s2){
        String res = "";
        res = s1+s2;
        return res;
    }
}
