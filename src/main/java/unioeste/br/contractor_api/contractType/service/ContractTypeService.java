package unioeste.br.contractor_api.contractType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contractType.model.ContractType;
import unioeste.br.contractor_api.contractType.repository.ContractTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractTypeService {

    @Autowired
    private ContractTypeRepository repository;

    public Page<ContractType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<ContractType> findById(Long id) {
        return repository.findById(id);
    }

    public ContractType save(ContractType contractType) {
        return repository.save(contractType);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
