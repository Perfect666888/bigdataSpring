package com.bigdata.student.service.impl;

import com.bigdata.student.bean.User;
import com.bigdata.student.dao.UserDao;
import com.bigdata.student.dao.impl.UserDaoImpl;
import com.bigdata.student.service.UserService;
import com.bigdata.student.util.DBUtils;
import com.bigdata.student.util.MD5Util;

import java.util.List;

public class UserServiceimpl implements UserService {
    //创建dao的具体实现对象
    private UserDao userDao = new UserDaoImpl();


    //注册服务
    @Override
    public boolean regesiter(User user) {

        //先调用dao的用户名是否存在功能
        List<User> lists = userDao.query(user.getUsername());

        //判断是否为空
        if (lists.isEmpty()) {
            //对于密码进行加密
            user.setPassword(MD5Util.getMD5(user.getPassword()));

            //调用注册功能,返回的是影响的行数
            int insert = userDao.insert(user);
            if(insert>0){
                return  true;
            }
            return false;
        } else {
            //不为空,返回false
            return false;
        }
    }

    @Override
    public boolean login(User user) {
        //先获取dao中的查询有无匹配对象的方法
        List<User> lists = userDao.select(user);

        //返回判断是否为空结果
        return lists.isEmpty();
    }
}
