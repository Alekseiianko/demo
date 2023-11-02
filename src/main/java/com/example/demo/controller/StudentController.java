package com.example.demo.controller;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Gender;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students") //*address*/students/get-by-gender
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/get-by-gender")
    public List<StudentResponse> findByGender(@RequestParam Gender gender) {
        return service.findByGender(gender);
    }

    @PostMapping("/create-student")
    public StudentResponse createStudent(@RequestBody StudentRequest student) {
        return service.saveStudent(student);
    }

    @PatchMapping("/update-student/{studentId}")
    public StudentResponse patchStudent(@RequestBody StudentRequest student,
                                        @PathVariable Long studentId) {
        return service.patchStudent(studentId, student);
    }

    @DeleteMapping("/delete-student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        service.deleteStudent(studentId);
    }
}
