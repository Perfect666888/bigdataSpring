package com.bigdata.student.Controller;


import com.bigdata.student.bean.Message;
import com.bigdata.student.bean.User;
import com.bigdata.student.service.UserService;
import com.bigdata.student.service.impl.UserServiceimpl;
import com.bigdata.student.util.DBUtils;
import com.bigdata.student.util.MD5Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //创建业务层的具体实现对象
    private UserService userService = new UserServiceimpl();


    @PostMapping("/login")
    public Message login(String username, String password) {

        //把信息存为用户对象,并且调用服务的是否存在对象方法
        boolean flag = userService.login(new User(username, MD5Util.getMD5(password)));

        //判断flag是否为真，真就是空，也就是没有该用户
        if (flag) {
            return new Message("error", "用户名或者密码错误");
        } else {
            return new Message("success", "登陆成功");
        }

    }

    @PostMapping("/changepass")
    public Message change(String username, String password, String newPassword, String new2Password) {

        //把信息存为用户对象,并且调用服务的是否存在对象方法
        boolean flag = userService.login(new User(username, MD5Util.getMD5(password)));

        //判断flag是否为真，真就是空，也就是没有该用户
        if (flag) {
            return new Message("error", "用户名或者密码错误");
        }

        //判断新旧密码是否相同
        if(MD5Util.getMD5(password).equals(MD5Util.getMD5(newPassword))){
            return new Message("error", "新旧密码不能相同");
        }

        //存在改账号
        //判断新密码2次是不是相同
        if (newPassword.equals(new2Password)) {

            //相同调用服务层的修改密码方法
            boolean changepass = userService.changepass(new User(username, MD5Util.getMD5(newPassword)));
            if (changepass) {
                return new Message("success", "密碼修改成功");
            } else {
                return new Message("error", "密碼修改失败");
            }
        } else {
            //不相同,告知错误信息
            return new Message("error", "2次输入的密码不相同");
        }

    }


    @PostMapping("/register")
    public Message register(String username, String password, String newPassword) {

        //先判断2次输入的密码是不是相同
        if (!password.equals(newPassword)) {
            //不相同,告知错误信息
            return new Message("error", "2次输入的密码不相同");

        }

        //相同调用业务层的注册方法,返回注册是否成功信息
        boolean regesiter = userService.regesiter(new User(username, password));

        if (regesiter) {
            return new Message("success", "注册成功");
        } else {
            return new Message("error", "该用户名已存在");
        }
    }
}
