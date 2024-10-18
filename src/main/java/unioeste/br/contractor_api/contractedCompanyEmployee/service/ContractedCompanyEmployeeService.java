package unioeste.br.contractor_api.contractedCompanyEmployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.contractedCompanyEmployee.repository.ContractedCompanyEmployeeRepository;

import java.util.Optional;

@Service
public class ContractedCompanyEmployeeService {

    @Autowired
    private ContractedCompanyEmployeeRepository repository;

    public Page<ContractedCompanyEmployee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<ContractedCompanyEmployee> findByCompanyId(Long companyId, Pageable pageable) {
        return repository.findByCompanyId(companyId, pageable);
    }

    public Optional<ContractedCompanyEmployee> findById(Long id) {
        return repository.findById(id);
    }

    public ContractedCompanyEmployee save(ContractedCompanyEmployee employee) {
        return repository.save(employee);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
