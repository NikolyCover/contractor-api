package unioeste.br.contractor_api.hiringCompanyEmployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import unioeste.br.contractor_api.hiringCompanyEmployee.repository.HiringCompanyEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HiringCompanyEmployeeService {

    @Autowired
    private HiringCompanyEmployeeRepository repository;

    public Page<HiringCompanyEmployee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<HiringCompanyEmployee> findByCompanyId(Long companyId, Pageable pageable) {
        return repository.findByCompanyId(companyId, pageable);
    }

    public Optional<HiringCompanyEmployee> findById(Long id) {
        return repository.findById(id);
    }

    public HiringCompanyEmployee save(HiringCompanyEmployee employee) {
        return repository.save(employee);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
