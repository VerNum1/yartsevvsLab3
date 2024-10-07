package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import lombok.*;
import jakarta.persistence.*;

// Entity of database  bank
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false)
    String name;
    Integer numberOffices;
    Integer numberAtms;
    Integer numberEmployees;
    Integer numberUsers;
    Integer bankRating;
    Integer totalMoney;
    Float interestRate;
}