package tech.reliab.course.toropchida.yartsevvsLab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.PaymentAccount;

import java.util.List;

@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Long> {
    @Query(value = "SELECT pa FROM PaymentAccount pa WHERE pa.userId = :userId")
    List<PaymentAccount> selectByUserId(@Param("userId") Long userId);
}
