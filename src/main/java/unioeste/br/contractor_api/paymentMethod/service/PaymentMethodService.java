package unioeste.br.contractor_api.paymentMethod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.paymentMethod.model.PaymentMethod;
import unioeste.br.contractor_api.paymentMethod.repository.PaymentMethodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository repository;

    public List<PaymentMethod> getAllPaymentMethods() {
        return repository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(Long id) {
        return repository.findById(id);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    public void deletePaymentMethod(Long id) {
        repository.deleteById(id);
    }

    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod updatedPaymentMethod) {
        return repository.findById(id).map(paymentMethod -> {
            paymentMethod.setName(updatedPaymentMethod.getName());
            paymentMethod.setFrequency(updatedPaymentMethod.getFrequency());
            return repository.save(paymentMethod);
        }).orElseThrow(() -> new RuntimeException("PaymentMethod not found"));
    }
}
