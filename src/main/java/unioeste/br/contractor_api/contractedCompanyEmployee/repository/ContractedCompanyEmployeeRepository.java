package unioeste.br.contractor_api.contractedCompanyEmployee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;

import java.util.List;

public interface ContractedCompanyEmployeeRepository extends JpaRepository<ContractedCompanyEmployee, Long> {
    Page<ContractedCompanyEmployee> findByCompanyId(Long companyId, Pageable pageable);
}
