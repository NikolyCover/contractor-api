package unioeste.br.contractor_api.contractedCompanyEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;

public interface ContractedCompanyEmployeeRepository extends JpaRepository<ContractedCompanyEmployee, Long> {
}
