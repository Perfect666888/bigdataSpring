package com.bigdata.student;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHttpUtils {

    @Test
    public void testGet(){
        String url="http://localhost:8080/getscore?name=单乐蕊";
        String s = HttpUtil.doGet(url);
        System.out.println(s);
    }

    @Test
    public void testpost(){
        Map<String, String> map = new HashMap<>();
        map.put("username","123");
        map.put("password","345");

        String url ="http://localhost:8080/login";

        String s = HttpUtil.doPost(url, map);
        System.out.println(s);

    }
    @Test
    public void testpost2(){
        Map<String, String> map = new HashMap<>();
        map.put("username","123");
        map.put("password","345");
        map.put("newPassword","345");

        String url ="http://localhost:8080/register";

        String s = HttpUtil.doPost(url, map);
        System.out.println(s);

    }

}
