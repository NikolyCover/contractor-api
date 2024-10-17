package unioeste.br.contractor_api.hiringCompanyEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import java.util.List;

public interface HiringCompanyEmployeeRepository extends JpaRepository<HiringCompanyEmployee, Long> {
    List<HiringCompanyEmployee> findByCompanyId(Long companyId);
}
