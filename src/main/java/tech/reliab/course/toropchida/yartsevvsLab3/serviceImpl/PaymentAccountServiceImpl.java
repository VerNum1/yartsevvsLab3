package tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.PaymentAccount;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankUserRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.PaymentAccountRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.service.PaymentAccountService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;
import static tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils.getNullPropertyNames;

@Service
public class PaymentAccountServiceImpl implements PaymentAccountService {

    public final PaymentAccountRepository paymentAccountRepo;
    public final BankUserRepository bankUserRepository;

    @Autowired
    public PaymentAccountServiceImpl(PaymentAccountRepository paymentAccountRepo, BankUserRepository bankUserRepository) {
        this.paymentAccountRepo = paymentAccountRepo;
        this.bankUserRepository = bankUserRepository;
    }

    public PaymentAccount createPaymentAccount(PaymentAccount paymentAccount) {
        paymentAccount.setCurrentAmount(0);

        PaymentAccount pa = paymentAccountRepo.save(paymentAccount);

        bankUserRepository.setPaymentAccountIdByUserId(pa.getId(), pa.getUserId());

        return pa;
    }

    public List<PaymentAccount> getAllPaymentAccounts() { return paymentAccountRepo.findAll(); }

    public Optional<PaymentAccount> getPaymentAccount(Long id) { return paymentAccountRepo.findById(id); }

    public PaymentAccount updatePaymentAccount(Long id, PaymentAccount PaymentAccDetail) {
        Optional<PaymentAccount> PaymentAccount = paymentAccountRepo.findById(id);

        if (PaymentAccount.isPresent()) {
            PaymentAccount existingIntern = PaymentAccount.get();
            String[] ignore = getNullPropertyNames(existingIntern);
            copyProperties(PaymentAccDetail, existingIntern, getNullPropertyNames(PaymentAccDetail));
            System.out.println(Arrays.toString(ignore));

            existingIntern.setId(PaymentAccDetail.getId());
            return paymentAccountRepo.save(existingIntern);
        }

        return null;
    }

    public void deletePaymentAccount(Long id) { paymentAccountRepo.deleteById(id); }

    public void deleteAllPaymentAccounts() { paymentAccountRepo.deleteAll(); }
}
