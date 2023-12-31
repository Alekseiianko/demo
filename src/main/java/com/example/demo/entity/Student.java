package com.example.demo.entity;

import com.example.demo.dto.response.StudentResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(name = "studentSequence", sequenceName = "student_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentSequence")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public StudentResponse convertToResponse() {
        StudentResponse response = new StudentResponse();
        response.setId(this.getId());
        response.setGender(this.getGender());
        response.setName(this.getName());
        if (this.getCourse() == null) {
            response.setCourseId(null);
        } else {
            response.setCourseId(this.getCourse().getId());
        }
        return response;
    }
}
