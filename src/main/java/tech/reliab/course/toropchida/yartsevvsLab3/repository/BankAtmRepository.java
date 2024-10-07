package tech.reliab.course.toropchida.yartsevvsLab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankAtm;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankOffice;

import java.util.List;

@Repository
public interface BankAtmRepository extends JpaRepository<BankAtm, Long> {
    @Query(value = "SELECT atm FROM BankAtm atm WHERE atm.bankId = :bankId")
    List<BankAtm> getBankAtmByBankId(@Param("bankId") Long bankId);
}
