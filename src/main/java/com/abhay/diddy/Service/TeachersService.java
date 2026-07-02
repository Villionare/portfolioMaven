package com.abhay.diddy.Service;

import com.abhay.diddy.Entity.Teachers;
import com.abhay.diddy.Repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersService {

    @Autowired
    TeachersRepository teachersRepository;

    public Teachers addTeacher(Teachers teacher){
        return teachersRepository.save(teacher);
    }
}
