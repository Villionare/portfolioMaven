package com.abhay.diddy.Controller;

import com.abhay.diddy.Entity.Student;
import com.abhay.diddy.Entity.Teachers;
import com.abhay.diddy.Service.StudentService;
import com.abhay.diddy.Service.TeachersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {

    private final StudentService service;
    private final TeachersService teachersService;

    public RESTController(StudentService service, TeachersService teachersService) {
        this.service = service;
        this.teachersService = teachersService;
    }

    //getting the student with a specific roll no.
    @GetMapping("/projects/{no}")
    public String me(@RequestParam String name, @PathVariable int no){
        return "this is about me! and i am " + name + " " + no;
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        service.addStudent(student);
        return "did it";
    }

    //adding a teacher
    @PostMapping("/addteacher")
    public Teachers addTeachers(@RequestBody Teachers teachers){
        return teachersService.addTeacher(teachers);
    }

    //getting a teacher
    @GetMapping("/gettechers")
    public List<Teachers> getTeachers(){
        return teachersService.getAllTeachers();
    }

    //updating a teacher
    @PutMapping("/updateteacher")
    public Teachers updateTeacher(@RequestBody Teachers updating_teachers){
        return teachersService.updateTeacherByID(updating_teachers.getID(), updating_teachers);
    }

    @DeleteMapping("/deleteteacher")
    public String deleteTeacher(@RequestBody Teachers teachers){
        return teachersService.deleteTeacher(teachers.getID());
    }

    //deleting a teacher


//    @GetMapping("/path/{n}")
//    public int pathVar(@PathVariable int n){
//        return n;
//    }
//
//    @PostMapping("postone")
//    public Person gettingIn(){
//        Person person = new Person();
//        return person;
//    }
//
//    @PostMapping("/person")
//    public String json_data(@RequestBody Person person){
//        return "Hello " + person.getName() + " of " + person.getAge();
//    }

}