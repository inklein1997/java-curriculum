package com.example.studentservice.controller;

import com.example.studentservice.models.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentServiceController {

    // This data would come from your db in real life.
    private static List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student("Sam"),
            new Student("Lisa"),
            new Student("Ming"),
            new Student("Lynda")
    ));

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentList;
    }

    @RequestMapping(value = "/students/{index}", method = RequestMethod.GET)
    public Student getStudentByIndex(@PathVariable int index) {
        return studentList.get(index);
    }

//    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
//    public Student getStudentByName(@PathVariable String name) {
//        Student selectedStudent = null;
//
//        for (Student student: studentList){
//            if(student.getName().equals(name)){
//                selectedStudent = student;
//            }
//        }
//
//        return selectedStudent;
//    }
}
