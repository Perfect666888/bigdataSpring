package com.bigdata.student.Controller;



import com.bigdata.student.bean.student_Score;
import com.bigdata.student.service.impl.studentServiceimpl;
import com.bigdata.student.service.studentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class GetScore {

    private studentService ss =new studentServiceimpl();

    @GetMapping("/getscore")
    public List<student_Score> getscore(String name) {

        List<student_Score> lists = ss.getscore(name);

        //返回结果
        return lists;
    }
}
