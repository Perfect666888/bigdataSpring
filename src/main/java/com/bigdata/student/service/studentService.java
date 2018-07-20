package com.bigdata.student.service;

import com.bigdata.student.bean.student_Score;

import java.util.List;

public interface studentService {
    public List<student_Score> getscore(String name);
}
