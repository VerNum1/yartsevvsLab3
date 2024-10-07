package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import jakarta.persistence.*;
import lombok.*;

// Entity of database  bank_office
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    Boolean status;

    @Column(nullable = false)
    Boolean freePlaceForAtm;

    Integer numberAtms;

    @Column(nullable = false)
    Boolean creditServices;

    @Column(nullable = false)
    Boolean issuesMoney;

    @Column(nullable = false)
    Boolean depositMoney;

    Integer totalMoney;

    @Column(nullable = false)
    Integer rent;

    @Column(nullable = false)
    Long bankId;
}
