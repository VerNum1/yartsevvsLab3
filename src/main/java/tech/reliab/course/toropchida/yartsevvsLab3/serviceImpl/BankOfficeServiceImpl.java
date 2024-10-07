package tech.reliab.course.toropchida.yartsevvsLab3.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.toropchida.yartsevvsLab3.entity.BankOffice;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankOfficeRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.repository.BankRepository;
import tech.reliab.course.toropchida.yartsevvsLab3.service.BankOfficeService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;
import static tech.reliab.course.toropchida.yartsevvsLab3.utils.Utils.getNullPropertyNames;

@Service
@AllArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {
    public final BankOfficeRepository bankOfficeRepo;
    public final BankRepository bankRepository;

    public BankOffice createBankOffice(BankOffice office) {
        Long bankId = office.getBankId();

        office.setNumberAtms(bankRepository.getNumberAtmsByBankId(bankId));
        office.setTotalMoney(bankRepository.getTotalMoneyByBankId(bankId));

        bankRepository.incrementNumberOfficesByBankId(bankId);

        return bankOfficeRepo.save(office);
    }

    public List<BankOffice> getAllBankOffices() { return bankOfficeRepo.findAll(); }

    public Optional<BankOffice> getBankOffice(Long id) { return bankOfficeRepo.findById(id); }

    public BankOffice updateBankOffice(Long id, BankOffice officeDetail) {
        Optional<BankOffice> BankOffice = bankOfficeRepo.findById(id);

        if (BankOffice.isPresent()) {
            BankOffice existingIntern = BankOffice.get();
            String[] ignore = getNullPropertyNames(existingIntern);
            copyProperties(officeDetail, existingIntern, getNullPropertyNames(officeDetail));
            System.out.println(Arrays.toString(ignore));

            existingIntern.setId(officeDetail.getId());
            return bankOfficeRepo.save(existingIntern);
        }

        return null;
    }

    public void deleteBankOffice(Long id) { bankOfficeRepo.deleteById(id); }

    public void deleteAllBanksOffices() { bankOfficeRepo.deleteAll(); }
}
