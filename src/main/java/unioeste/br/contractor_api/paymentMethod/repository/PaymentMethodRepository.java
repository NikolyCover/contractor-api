package unioeste.br.contractor_api.paymentMethod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.paymentMethod.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
