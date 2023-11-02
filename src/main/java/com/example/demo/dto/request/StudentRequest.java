package com.example.demo.dto.request;

import com.example.demo.entity.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

public class StudentRequest {

    private String name;

    private Gender gender;

    private Long courseId;

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
