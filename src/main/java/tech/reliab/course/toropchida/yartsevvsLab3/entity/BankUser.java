package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

// Entity of database  user
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String fullName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date dateOfBirth;

    @Column(nullable = false)
    String workplace;

    Integer monthlyIncome;

    @Column(nullable = false)
    String bankUsed;

    Long creditAccountId;
    Long paymentAccountId;
    Integer creditRating;
}
