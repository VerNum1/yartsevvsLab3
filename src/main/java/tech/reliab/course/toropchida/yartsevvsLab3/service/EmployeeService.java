package tech.reliab.course.toropchida.yartsevvsLab3.service;

import tech.reliab.course.toropchida.yartsevvsLab3.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee Employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployee(Long id);

    Employee updateEmployee(Long id, Employee employeeDetails);

    void deleteEmployee(Long id);

    void deleteAllEmployees();
}
