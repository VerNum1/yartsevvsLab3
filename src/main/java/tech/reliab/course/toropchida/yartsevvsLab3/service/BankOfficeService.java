package tech.reliab.course.toropchida.yartsevvsLab3.service;

import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankOffice;

import java.util.List;
import java.util.Optional;


public interface BankOfficeService {
    BankOffice createBankOffice(BankOffice bank);

    List<BankOffice> getAllBankOffices();

    Optional<BankOffice> getBankOffice(Long id);

    BankOffice updateBankOffice(Long id, BankOffice officeDetail);

    void deleteBankOffice(Long id);

    void deleteAllBanksOffices();
}
