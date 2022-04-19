package com.hamitmizrak.data.jpql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "teacher")
public class TeacherEntity implements Serializable {
    public static final long serialVersionUID=1L;

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
