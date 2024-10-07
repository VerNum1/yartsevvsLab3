package tech.reliab.course.toropchida.yartsevvsLab3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity of database  payment_account
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    Long userId;

    @Column(nullable = false)
    String bankName;

    @Column(nullable = false)
    Integer currentAmount;
}
