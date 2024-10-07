package tech.reliab.course.toropchida.yartsevvsLab3.service;

import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankAtm;

import java.util.List;
import java.util.Optional;


public interface BankAtmService {

    BankAtm createBankAtm(BankAtm bank);

    List<BankAtm> getAllBankAtms();

    Optional<BankAtm> getBankAtm(Long id);

    BankAtm updateBankAtm(Long id, BankAtm atmDetail);

    void deleteBankAtm(Long id);

    void deleteAllBanksAtms();
}
