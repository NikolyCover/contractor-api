package unioeste.br.contractor_api.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contract.model.Contract;
import unioeste.br.contractor_api.contract.repository.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;

    public List<Contract> findAll() {
        return repository.findAll();
    }

    public Optional<Contract> findById(Long id) {
        return repository.findById(id);
    }

    public Contract save(Contract contract) {
        return repository.save(contract);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
