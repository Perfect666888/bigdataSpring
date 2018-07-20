package com.bigdata.student.service.impl;

import com.bigdata.student.bean.student_Score;
import com.bigdata.student.dao.impl.studentDaoImpl;
import com.bigdata.student.dao.studentDao;
import com.bigdata.student.service.studentService;

import java.util.List;

public class studentServiceimpl  implements studentService {

    private studentDao std = new studentDaoImpl();

    @Override
    public List<student_Score> getscore(String name) {
        List<student_Score> lists = std.getscore(name);
        return lists;
    }
}
