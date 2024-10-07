package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

// Entity of database  credit_account
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    Long userId;

    @Column(nullable = false)
    String bankName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date creditStartDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date creditEndDate;

    @Column(nullable = false)
    Integer creditMonthlyDuration;

    @Column(nullable = false)
    Integer creditAmount;

    @Column(nullable = false)
    Integer monthlyPayment;

    @Column(nullable = false)
    Float interestRate;

    @Column(nullable = false)
    Long employeeId;

    @Column(nullable = false)
    Long paymentAccountId;
}
