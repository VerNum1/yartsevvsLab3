package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

// Entity of database  employee
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String fullName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date dateOfBirth;

    @Column(nullable = false)
    String post;

    @Column(nullable = false)
    Long bankId;

    @Column(nullable = false)
    Boolean officeWorkFormat;

    @Column(nullable = false)
    Long bankOfficeId;

    @Column(nullable = false)
    Boolean creditServices;

    @Column(nullable = false)
    Integer salary;
}
