package com.example.studentservice.contoller;

import com.example.studentservice.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentServiceController {
    private List<Student> studentList;

    public StudentServiceController() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Andy", 20));
        studentList.add(new Student("Jose", 8));
        studentList.add(new Student("Kevin", 21));
        studentList.add(new Student("Alonzo", 10));

//        studentList = Arrays.asList(new Student("Andy", 20),new Student("Jose", 8),new Student("Kevin", 21),new Student("Alonzo", 10));
    }

    @RequestMapping(value="/students", method= RequestMethod.GET)
    public List<Student> getStudents() {
        return studentList;
    }

//    @RequestMapping(value="/students/{theIndexOfTheStudent}", method=RequestMethod.GET)
//    public Student getStudentByIndex(@PathVariable int theIndexOfTheStudent) {
//        return studentList.get(theIndexOfTheStudent);
//    }

    @RequestMapping(value="/students/{studentName}", method=RequestMethod.GET)
    public Student getStudentByName(@PathVariable String studentName) {
        for (Student student : studentList) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }

        // OR USE A STREAM!!!
        // List<Student> matchingStudentList = studentList.stream().filter(stu -> stu.getName().equals(studentName)).collect(Collectors.toList());
        // return matchingStudentList.get(0);
        return null;
    }
}
