package tech.reliab.course.toropchida.yartsevvsLab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query(value = "SELECT b.totalMoney FROM Bank b WHERE b.id = :id")
    int getTotalMoneyByBankId(@Param("id") Long id);

    @Query(value = "SELECT b.numberAtms FROM Bank b WHERE b.id = :id")
    int getNumberAtmsByBankId(@Param("id") Long id);

    @Query(value = "SELECT b.interestRate FROM Bank b WHERE b.name = :name")
    float getInterestRateByBankName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bank b SET b.numberUsers = b.numberUsers + 1 WHERE b.name = :name")
    void incrementNumberUsersByBankName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bank b SET b.numberEmployees = b.numberEmployees + 1 WHERE b.id = :id")
    void incrementNumberEmployeesByBankId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bank b SET b.numberAtms = b.numberAtms + 1 WHERE b.id = :id")
    void incrementNumberAtmsByBankId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bank b SET b.numberOffices = b.numberOffices + 1 WHERE b.id = :id")
    void incrementNumberOfficesByBankId(@Param("id") Long id);
}
