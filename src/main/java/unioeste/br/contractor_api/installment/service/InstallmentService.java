package unioeste.br.contractor_api.installment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contract.domain.entity.Contract;
import unioeste.br.contractor_api.installment.model.Installment;
import unioeste.br.contractor_api.installment.repository.InstallmentRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstallmentService {

    private final InstallmentRepository installmentRepository;

    public Page<Installment> findAll(Pageable pageable) {
        return installmentRepository.findAll(pageable);
    }

    public Installment save(Installment installment) {
        return installmentRepository.save(installment);
    }

    public void deleteById(Long id) {
        installmentRepository.deleteById(id);
    }

    public void createContractInstallments(Contract contract) {
        List<Installment> installments = new ArrayList<>();

        long totalMonths = ChronoUnit.MONTHS.between(contract.getStartDate(), contract.getEndDate());
        int numInstallments = (int) (totalMonths / contract.getPaymentMethod().getFrequency());

        double installmentValue = contract.getContractedValue() / numInstallments;

        LocalDate date = contract.getStartDate();

        for (int i = 0; i < numInstallments; i++) {
            Installment installment = new Installment();
            installment.setContract(contract);
            installment.setScheduledPaymentDate(date);
            installment.setValue(installmentValue);
            installment.setPaymentDate(null);
            installment.setPaymentReceiptURL(null);

            installments.add(installment);

            date = date.plusMonths(contract.getPaymentMethod().getFrequency());
        }

        installmentRepository.saveAll(installments);
    }
}
