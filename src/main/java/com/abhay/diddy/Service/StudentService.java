package com.abhay.diddy.Service;

import com.abhay.diddy.Entity.Student;
import com.abhay.diddy.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public Student addStudent(Student student){
        return repository.save(student);
    }
}