package com.example.demo.dto.response;

import com.example.demo.entity.Gender;

public class StudentResponse {

    private Long id;

    private String name;

    private Gender gender;

    private Long courseId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Long getCourseId() {
        return courseId;
    }
}
