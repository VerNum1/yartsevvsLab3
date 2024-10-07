package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import jakarta.persistence.*;
import lombok.*;

// Entity of database  bank_atm
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAtm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;
    String address;
    String status;
    Long bankId;
    Long bankOfficeId;
    Long employeeId;
    Boolean issuesMoney;
    Boolean depositMoney;
    Integer totalMoney;
    Integer costMaintenance;
}
