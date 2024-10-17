package unioeste.br.contractor_api.contractedCompanyEmployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.contractedCompanyEmployee.repository.ContractedCompanyEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractedCompanyEmployeeService {

    @Autowired
    private ContractedCompanyEmployeeRepository repository;

    public List<ContractedCompanyEmployee> findAll() {
        return repository.findAll();
    }

    public List<ContractedCompanyEmployee> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
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
