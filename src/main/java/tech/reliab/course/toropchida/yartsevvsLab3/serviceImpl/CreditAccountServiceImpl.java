package tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.CreditAccount;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankUserRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.CreditAccountRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.service.CreditAccountService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;
import static tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils.getNullPropertyNames;

@Service
@AllArgsConstructor
public class CreditAccountServiceImpl implements CreditAccountService {
    public final CreditAccountRepository creditAccountRepo;
    public final BankRepository bankRepository;
    public final BankUserRepository bankUserRepository;

    public CreditAccount createCreditAccount(CreditAccount creditAccount) {
        creditAccount.setInterestRate(bankRepository.getInterestRateByBankName(creditAccount.getBankName()));

        CreditAccount ca = creditAccountRepo.save(creditAccount);

        bankUserRepository.setCreditAccountIdByUserId(ca.getId(), ca.getUserId());

        return ca;
    }

    public List<CreditAccount> getAllCreditAccounts() { return creditAccountRepo.findAll(); }

    public Optional<CreditAccount> getCreditAccount(Long id) { return creditAccountRepo.findById(id); }

    public CreditAccount updateCreditAccount(Long id, CreditAccount creditAccDetail) {
        Optional<CreditAccount> CreditAccount = creditAccountRepo.findById(id);

        if (CreditAccount.isPresent()) {
            CreditAccount existingIntern = CreditAccount.get();
            String[] ignore = getNullPropertyNames(existingIntern);
            copyProperties(creditAccDetail, existingIntern, getNullPropertyNames(creditAccDetail));
            System.out.println(Arrays.toString(ignore));

            existingIntern.setId(creditAccDetail.getId());
            return creditAccountRepo.save(existingIntern);
        }

        return null;
    }

    public void deleteCreditAccount(Long id) { creditAccountRepo.deleteById(id); }

    public void deleteAllCreditAccounts() { creditAccountRepo.deleteAll(); }
}
