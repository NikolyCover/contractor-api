package unioeste.br.contractor_api.paymentMethod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.paymentMethod.model.PaymentMethod;
import unioeste.br.contractor_api.paymentMethod.service.PaymentMethodService;

@CrossOrigin
@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService service;

    @GetMapping
    public Page<PaymentMethod> getAllPaymentMethods(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return service.save(paymentMethod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        return ResponseEntity.ok(service.update(id, paymentMethod));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
