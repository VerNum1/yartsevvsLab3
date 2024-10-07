package tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.*;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.*;
import tech.reliab.course.toropchida.yartsevvsLab3.service.BankService;
import tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;
import static tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils.getNullPropertyNames;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {
    public final BankRepository bankRepo;
    public final BankAtmRepository bankAtmRepository;
    public final BankOfficeRepository bankOfficeRepository;
    public final EmployeeRepository employeeRepository;
    public final BankUserRepository bankUserRepository;

    @Override
    public Bank createBank(Bank bank) {
        bank.setNumberOffices(0);
        bank.setNumberAtms(0);
        bank.setNumberEmployees(0);
        bank.setNumberUsers(0);
        int bankRating = Utils.getRandomIntFromAToB(0, 100);
        bank.setBankRating(bankRating);
        bank.setTotalMoney(Utils.getRandomIntFromAToB(1, 1000000));

        int a = 0, b = 20;
        int div = bankRating / 20;
        if (div >= 4) {
            b = 4;
        } else if (div == 3) {
            a = 4;
            b = 8;
        } else if (div == 2) {
            a = 8;
            b = 12;
        } else if (div == 1) {
            a = 12;
            b = 16;
        } else {
            a = 16;
        }

        bank.setInterestRate((float) (Math.random() * (b - a)) + (a));

        return bankRepo.save(bank);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepo.findAll();
    }

    @Override
    public Optional<Bank> getBank(Long id) {
        return bankRepo.findById(id);
    }

    @Override
    public Bank updateBank(Long id, Bank bankDetails) {
        Optional<Bank> bank = bankRepo.findById(id);

        if (bank.isPresent()) {
            Bank existingIntern = bank.get();
            String[] ignore = getNullPropertyNames(existingIntern);
            copyProperties(bankDetails, existingIntern, getNullPropertyNames(bankDetails));
            System.out.println(Arrays.toString(ignore));

            existingIntern.setId(bankDetails.getId());
            return bankRepo.save(existingIntern);
        }

        return null;
    }

    @Override
    public void deleteBank(Long id) {
        bankRepo.deleteById(id);
    }

    @Override
    public void deleteAllBanks() {
        bankRepo.deleteAll();
    }

    @Override
    public void outputAllBankInfo(Long id) {
        Optional<Bank> bank = getBank(id);
        if (bank.isPresent()) {
            List<BankUser> bankUsers = bankUserRepository.getBankUserByBankName(bank.get().getName());
            List<BankOffice> bankOffices = bankOfficeRepository.getBankOfficeByBankId(id);
            List<BankAtm> bankAtms = bankAtmRepository.getBankAtmByBankId(id);
            List<Employee> employees = employeeRepository.getEmployeeByBankId(id);

            System.out.println("Bank: " + bank);
            System.out.println("Offices:");
            for (BankOffice office : bankOffices) {
                System.out.println("\t" + office);
            }
            System.out.println("BankAtms:");
            for (BankAtm bankAtm : bankAtms) {
                System.out.println("\t" + bankAtm);
            }
            System.out.println("Employees:");
            for (Employee employee : employees) {
                System.out.println("\t" + employee);
            }
            System.out.println("Users:");
            for (BankUser user : bankUsers) {
                System.out.println("\t" + user);
            }
        } else {
            System.out.println("NOT-FOUND");
        }
    }
}
