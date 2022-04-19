package com.hamitmizrak.jpql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,name="teacher_id")
    private Long teacherId;

    @Column(name="teacher_name")
    private String teacherName;

    @Column(name="teacher_surname")
    private String teacherSurname;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creatationDate;
}
