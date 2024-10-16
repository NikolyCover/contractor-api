package unioeste.br.contractor_api.installment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.installment.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}
