package com.bigdata.student.dao;

import com.bigdata.student.bean.User;

import java.util.List;

public interface UserDao {


    //注册的前提是用户名不存在
    public List<User> query(String username);

    //注册
    //返回注册了几行
    public int insert(User user);

    //登陆
    public List<User> select(User user);

}
