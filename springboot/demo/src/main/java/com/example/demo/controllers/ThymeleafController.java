package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Student;

@Controller
public class ThymeleafController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/sendData")
    public ModelAndView sendData(){
        ModelAndView mav=new ModelAndView("display");
        mav.addObject("msg", "Vanakam da mapla");
        return mav;
    }

    @RequestMapping("/student")
    public ModelAndView getStudent(){
        ModelAndView mav=new ModelAndView("student");
        Student student=new Student();
        student.setName("Silku");
        student.setScore(100);
        mav.addObject("studentDetail", student);
        return mav;
    }
    @RequestMapping("/students")
    public ModelAndView getStudents(){
        ModelAndView mav=new ModelAndView("studentlist");
        Student student=new Student();
        student.setName("Silku");
        student.setScore(100);

        Student student1=new Student();
        student1.setName("Silku");
        student1.setScore(100);

        Student student2=new Student();
        student2.setName("Silku");
        student2.setScore(100);
        List<Student> students=Arrays.asList(student, student1, student2);
        mav.addObject("studentsDetail", students);
        return mav;
    }
}
