package com.bigdata.student.service;

import com.bigdata.student.bean.User;

import java.util.List;

public interface UserService {

    //注册用户
    public boolean regesiter(User user);


    //登陆用户
    public boolean login(User user);

    //修改密碼
    public boolean changepass(User user);
}
