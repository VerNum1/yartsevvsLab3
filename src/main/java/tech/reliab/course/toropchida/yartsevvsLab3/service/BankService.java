package tech.reliab.course.toropchida.yartsevvsLab3.service;

import tech.reliab.course.toropchida.yartsevvsLab3.entity.Bank;

import java.util.*;

public interface BankService {
    Bank createBank(Bank bank);

    List<Bank> getAllBanks();

    Optional<Bank> getBank(Long id);

    Bank updateBank(Long id, Bank bankDetails);

    void deleteBank(Long id);

    void deleteAllBanks();

    void outputAllBankInfo(Long id);
}
