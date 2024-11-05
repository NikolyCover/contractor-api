package unioeste.br.contractor_api.company.hiringCompany.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.company.contractedCompany.domain.entity.ContractedCompany;
import unioeste.br.contractor_api.company.hiringCompany.domain.entity.HiringCompany;
import unioeste.br.contractor_api.company.hiringCompany.repository.HiringCompanyRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class HiringCompanyService {

    @Autowired
    private HiringCompanyRepository repository;

    public Page<HiringCompany> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<HiringCompany> findById(Long id) {
        return repository.findById(id);
    }

    public HiringCompany save(HiringCompany company) {
        return repository.save(company);
    }

    public Optional<HiringCompany> update(Long id, HiringCompany companyDetails) {
        return repository.findById(id).map(company -> {
            company.setName(companyDetails.getName());
            company.setCorporateName(companyDetails.getCorporateName());
            company.setCode(companyDetails.getCode());
            company.setPhone(companyDetails.getPhone());
            company.setEmail(companyDetails.getEmail());
            company.setAddress(companyDetails.getAddress());
            company.setMatrix(companyDetails.isMatrix());
            return repository.save(company);
        });
    }

    public void deleteHiringCompany(Long id) {
        repository.deleteById(id);
    }

    public String findAllAsString() {
        return "Aqui estão os dados das empresas contratantes que constam no sistema:\n\n" +
                repository.findAll().stream()
                        .map(HiringCompany::toString)
                        .collect(Collectors.joining("\n\n"));
    }
}
