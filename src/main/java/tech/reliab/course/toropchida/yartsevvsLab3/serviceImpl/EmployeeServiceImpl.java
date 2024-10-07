package tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.Employee;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.EmployeeRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.service.EmployeeService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;
import static tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils.getNullPropertyNames;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    public final EmployeeRepository employeeRepo;
    public final BankRepository bankRepository;

    public Employee createEmployee(Employee employee) {
        bankRepository.incrementNumberEmployeesByBankId(employee.getBankId());

        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() { return employeeRepo.findAll(); }

    public Optional<Employee> getEmployee(Long id) { return employeeRepo.findById(id); }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> Employee = employeeRepo.findById(id);

        if (Employee.isPresent()) {
            Employee existingIntern = Employee.get();
            String[] ignore = getNullPropertyNames(existingIntern);
            copyProperties(employeeDetails, existingIntern, getNullPropertyNames(employeeDetails));
            System.out.println(Arrays.toString(ignore));

            existingIntern.setId(employeeDetails.getId());
            return employeeRepo.save(existingIntern);
        }

        return null;
    }

    public void deleteEmployee(Long id) { employeeRepo.deleteById(id); }

    public void deleteAllEmployees() { employeeRepo.deleteAll(); }
}
