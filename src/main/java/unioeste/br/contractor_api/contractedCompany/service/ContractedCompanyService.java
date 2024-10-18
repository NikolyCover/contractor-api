package unioeste.br.contractor_api.contractedCompany.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;
import unioeste.br.contractor_api.contractedCompany.repository.ContractedCompanyRepository;

import java.util.Optional;

@Service
@Log4j2
public class ContractedCompanyService {

    @Autowired
    private ContractedCompanyRepository repository;

    public Page<ContractedCompany> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<ContractedCompany> findById(Long id) {
        return repository.findById(id);
    }

    public ContractedCompany save(ContractedCompany company) {
        return repository.save(company);
    }

    public Optional<ContractedCompany> update(Long id, ContractedCompany companyDetails) {
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

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
