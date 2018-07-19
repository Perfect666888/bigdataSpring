package com.bigdata.student.controller;



import com.bigdata.student.bean.student_Score;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GetScore {

    @GetMapping("/getscore")
    public List<student_Score> getscore(String name) {

        //创建sql字符串
        String sql = "SELECT a.id,a.name,a.clazz,c.name as cname ,b.score from student as a join score as b on a.id =b.studentId \n" +
                "join cource as c on b.courceId=c.id  where a.name = ?";

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //创建集合存储结果
        ArrayList<student_Score> list = new ArrayList<>();

        //建立连接
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01","root", "123");
            //创建预执行器
            pst = con.prepareStatement(sql);

            //赋值
            pst.setString(1, name);

            //执行sql
            ResultSet resultSet = pst.executeQuery();


            //遍历集合赋值
            while (resultSet.next()) {
                //获得值
                String id = resultSet.getString("id");
                String name1 = resultSet.getString("name");
                String clazz = resultSet.getString("clazz");
                String cname = resultSet.getString("cname");
                int score = resultSet.getInt("score");

                //创建对象
                student_Score student = new student_Score(id, name1, clazz, cname, score);

                //存储到集合中
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //释放资源

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //返回结果
        return list;
    }
}
