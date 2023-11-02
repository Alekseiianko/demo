package com.example.demo.repository;

import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Course;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndGenderAndCourse(String name, Gender gender, Course course);

    @Query("select s from Student s where s.name = :name")
    List<Student> findByCustomParams(String name);

    List<Student> findByGender(Gender gender);
}
