package unioeste.br.contractor_api.installment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.installment.model.Installment;
import unioeste.br.contractor_api.installment.repository.InstallmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstallmentService {

    private final InstallmentRepository installmentRepository;

    public List<Installment> findAll() {
        return installmentRepository.findAll();
    }

    public Installment save(Installment installment) {
        return installmentRepository.save(installment);
    }

    public void deleteById(Long id) {
        installmentRepository.deleteById(id);
    }
}
