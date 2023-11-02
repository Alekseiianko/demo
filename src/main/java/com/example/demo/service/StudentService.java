package com.example.demo.service;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findStudentsBySomeName(String name) {
        List<Student> students = studentRepository.findByCustomParams(name);
        List<Student> returnStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(Gender.MALE)) {
                returnStudents.add(student);
            }
        }
        return returnStudents;
    }

    public List<StudentResponse> findByGender(Gender gender) {
        List<Student> students = studentRepository.findByGender(gender);
        return students.stream().map(Student::convertToResponse).collect(Collectors.toList());
    }

    public StudentResponse saveStudent(StudentRequest request) {
        Student student = new Student();
        student.setGender(request.getGender());
        student.setName(request.getName());
        Student saved = studentRepository.save(student);
        return saved.convertToResponse();
    }

    public StudentResponse patchStudent(Long studentId, StudentRequest request) {
        Student student = studentRepository.getById(studentId);
        student.setName(request.getName());
        student.setGender(request.getGender());
        return studentRepository.save(student).convertToResponse();
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.getById(studentId);
        studentRepository.delete(student);
    }
}
