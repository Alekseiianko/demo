package com.example.demo.dto.request;

import com.example.demo.entity.Gender;
import lombok.Data;

@Data
public class StudentRequest {

    private String name;

    private Gender gender;

    private Long courseId;
}
