package unioeste.br.contractor_api.installment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.installment.model.Installment;
import unioeste.br.contractor_api.installment.service.InstallmentService;

import java.util.List;

@RestController
@RequestMapping("/installment")
@RequiredArgsConstructor
public class InstallmentController {

    private final InstallmentService installmentService;

    @GetMapping
    public ResponseEntity<Page<Installment>> getAllInstallments(Pageable pageable) {
        return new ResponseEntity<>(installmentService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Installment> createInstallment(@RequestBody Installment installment) {
        return new ResponseEntity<>(installmentService.save(installment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstallment(@PathVariable Long id) {
        installmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
