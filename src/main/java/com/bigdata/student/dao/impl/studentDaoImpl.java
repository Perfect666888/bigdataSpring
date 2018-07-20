package com.bigdata.student.dao.impl;

import com.bigdata.student.bean.student_Score;
import com.bigdata.student.dao.studentDao;
import com.bigdata.student.util.DBUtils;

import java.util.List;

public class studentDaoImpl  implements studentDao {

    @Override
    public List<student_Score> getscore(String name) {
        //创建sql字符串
        String sql = "SELECT a.id,a.name,a.clazz,c.name as courcename ,b.score from student as a join score as b on a.id =b.studentId \n" +
                "join cource as c on b.courceId=c.id  where a.name = ?";

        List<student_Score> select = DBUtils.select(sql, student_Score.class, name);
        return select;
    }
}
