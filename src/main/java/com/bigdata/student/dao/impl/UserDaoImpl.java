package com.bigdata.student.dao.impl;

import com.bigdata.student.bean.User;
import com.bigdata.student.dao.UserDao;
import com.bigdata.student.util.DBUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {

    //查询用户名是否存在
    @Override
    public List<User> query(String username) {

        //创建sql查询语句
        String sql ="SELECT name as username,password as password from user where name =?";
        //在数据库中查询
        List<User> lists = DBUtils.select(sql, User.class, username);
        return lists;
    }

    @Override
    public int insert(User user) {
        //创建sql插入语句
        String sql ="insert into user (name,password) values (?,?)";

        //调用工具中的更新数据方法
        int update = DBUtils.update(sql,user.getUsername(),user.getPassword());

        return update;
    }


    //登陆
    @Override
    public List<User> select(User user) {
        //创建查询语句
        String sql ="SELECT name as username,password as password from user where name =? and password=?";

        //查询
        List<User> lists = DBUtils.select(sql, User.class, user.getUsername(), user.getPassword());

        return lists;
    }
}
