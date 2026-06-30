package com.abhay.diddy.Repository;

import com.abhay.diddy.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
