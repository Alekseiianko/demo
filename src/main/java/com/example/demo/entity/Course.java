package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
public class Course {

    @Id
    @SequenceGenerator(name = "courseSequence", sequenceName = "course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseSequence")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    List<Student> students;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
