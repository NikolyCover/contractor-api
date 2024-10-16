package unioeste.br.contractor_api.contractedCompany.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;
import unioeste.br.contractor_api.contractedCompany.repository.ContractedCompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ContractedCompanyService {

    @Autowired
    private ContractedCompanyRepository repository;

    public List<ContractedCompany> getAllContractedCompanies() {
        return repository.findAll();
    }

    public Optional<ContractedCompany> getContractedCompanyById(Long id) {
        return repository.findById(id);
    }

    public ContractedCompany createContractedCompany(ContractedCompany company) {
        return repository.save(company);
    }

    public Optional<ContractedCompany> updateContractedCompany(Long id, ContractedCompany companyDetails) {
        return repository.findById(id).map(company -> {
            company.setName(companyDetails.getName());
            company.setCorporateName(companyDetails.getCorporateName());
            company.setCode(companyDetails.getCode());
            company.setPhone(companyDetails.getPhone());
            company.setEmail(companyDetails.getEmail());
            company.setAddress(companyDetails.getAddress());
            return repository.save(company);
        });
    }

    public void deleteContractedCompany(Long id) {
        repository.deleteById(id);
    }
}
