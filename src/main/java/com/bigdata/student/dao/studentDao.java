package com.bigdata.student.dao;

import com.bigdata.student.bean.student_Score;

import java.util.List;

public interface studentDao {
    public List<student_Score> getscore(String name);
}
