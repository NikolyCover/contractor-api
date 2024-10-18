package unioeste.br.contractor_api.hiringCompanyEmployee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;

public interface HiringCompanyEmployeeRepository extends JpaRepository<HiringCompanyEmployee, Long> {
    Page<HiringCompanyEmployee> findByCompanyId(Long companyId, Pageable pageable);
}
