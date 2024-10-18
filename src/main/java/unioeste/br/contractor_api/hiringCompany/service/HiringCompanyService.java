package unioeste.br.contractor_api.hiringCompany.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.hiringCompany.model.HiringCompany;
import unioeste.br.contractor_api.hiringCompany.repository.HiringCompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class HiringCompanyService {

    @Autowired
    private HiringCompanyRepository repository;

    public List<HiringCompany> findAll() {
        return repository.findAll();
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
}
