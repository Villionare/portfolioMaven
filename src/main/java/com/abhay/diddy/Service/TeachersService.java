package com.abhay.diddy.Service;

import com.abhay.diddy.Entity.Teachers;
import com.abhay.diddy.Repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersService {

    @Autowired
    TeachersRepository teachersRepository;

    public Teachers addTeacher(Teachers teacher){
        return teachersRepository.save(teacher);
    }

    public List<Teachers> getAllTeachers(){

        //if wanna find by id
        //teachersRepository.findAllById(342).orElse(null);

        return teachersRepository.findAll();
    }

    public Teachers updateTeacherByID(Long ID, Teachers updating_teacher){

        Teachers findTeacher = teachersRepository.findById(ID).orElse(null);

        if(findTeacher==null){
            return null;
        }

        findTeacher.setName(updating_teacher.getName());
        findTeacher.setMarried(updating_teacher.isMarried());
        findTeacher.setSalary(updating_teacher.getSalary());

        teachersRepository.save(findTeacher);

        return findTeacher;
    }

    public String deleteTeacher(Long id){


        if (!teachersRepository.existsById(id)) {
            return "Teacher not found";
        }

        teachersRepository.deleteById(id);

        return "Deletion Done";
    }
}
