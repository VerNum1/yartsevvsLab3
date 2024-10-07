package tech.reliab.course.toropchida.yartsevvsLab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT empl FROM Employee empl WHERE empl.bankId = :bankId")
    List<Employee> getEmployeeByBankId(@Param("bankId") Long bankId);
}
