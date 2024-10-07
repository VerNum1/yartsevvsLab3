package tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankUser;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.CreditAccount;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.PaymentAccount;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankUserRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.CreditAccountRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.PaymentAccountRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.service.BankUserService;
import tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;
import static tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils.getNullPropertyNames;

@Service
@AllArgsConstructor
public class BankUserServiceImpl implements BankUserService {
    public final BankUserRepository UserRepo;
    public final BankRepository bankRepository;
    public final CreditAccountRepository creditAccountRepository;
    public final PaymentAccountRepository paymentAccountRepository;

    @Override
    public BankUser createUser(BankUser user) {
        int monthlyIncome = Utils.getRandomIntFromAToB(0, 10000);
        user.setMonthlyIncome(monthlyIncome);

        int a, b;
        if (monthlyIncome <= 1000){
            b = 100;
        } else {
            b = (int) Math.ceil((double) monthlyIncome / 1000) * 100;
        }
        a = b - 100;
        user.setCreditRating(Utils.getRandomIntFromAToB(a, b));

        bankRepository.incrementNumberUsersByBankName(user.getBankUsed());

        return UserRepo.save(user);
    }

    @Override
    public List<BankUser> getAllUsers() { return UserRepo.findAll(); }

    @Override
    public Optional<BankUser> getUser(Long id) { return UserRepo.findById(id); }

    @Override
    public BankUser updateUser(Long id, BankUser bankUserDetail) {
        Optional<BankUser> User = UserRepo.findById(id);

        if (User.isPresent()) {
            BankUser existingIntern = User.get();
            String[] ignore = getNullPropertyNames(existingIntern);
            copyProperties(bankUserDetail, existingIntern, getNullPropertyNames(bankUserDetail));
            System.out.println(Arrays.toString(ignore));

            existingIntern.setId(bankUserDetail.getId());
            return UserRepo.save(existingIntern);
        }

        return null;
    }

    @Override
    public void deleteUser(Long id) { UserRepo.deleteById(id); }

    @Override
    public void deleteAllUsers() { UserRepo.deleteAll(); }

    @Override
    public void outputAllUserInfo(Long id) {
        Optional<BankUser> user = getUser(id);
        if (user.isPresent()) {
            System.out.println("Bank User:");
            System.out.println("\t" + user.get());

            List<CreditAccount> creditAccounts = creditAccountRepository.selectByUserId(id);
            List<PaymentAccount> paymentAccounts = paymentAccountRepository.selectByUserId(id);

            System.out.println("Credit Account:");
            for (CreditAccount creditAccount : creditAccounts) {
                System.out.println("\t" + creditAccount);
            }
            System.out.println("Payment Account:");
            for (PaymentAccount paymentAccount : paymentAccounts) {
                System.out.println("\t" + paymentAccount);
            }
        }
        else {
            System.out.println("NOT-FOUND");
        }
    }
}
