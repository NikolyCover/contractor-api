package unioeste.br.contractor_api.contract.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contract.domain.dto.ContractFormDTO;
import unioeste.br.contractor_api.contract.domain.entity.Contract;
import unioeste.br.contractor_api.contract.service.ContractService;
import unioeste.br.contractor_api.contractItem.service.ContractItemService;
import unioeste.br.contractor_api.contractType.model.ContractType;
import unioeste.br.contractor_api.contractType.service.ContractTypeService;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;
import unioeste.br.contractor_api.contractedCompany.service.ContractedCompanyService;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.contractedCompanyEmployee.service.ContractedCompanyEmployeeService;
import unioeste.br.contractor_api.hiringCompany.model.HiringCompany;
import unioeste.br.contractor_api.hiringCompany.service.HiringCompanyService;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import unioeste.br.contractor_api.hiringCompanyEmployee.service.HiringCompanyEmployeeService;
import unioeste.br.contractor_api.installment.service.InstallmentService;
import unioeste.br.contractor_api.paymentMethod.model.PaymentMethod;
import unioeste.br.contractor_api.paymentMethod.service.PaymentMethodService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
@AllArgsConstructor
public class ContractController {

    private ContractService service;
    private PaymentMethodService paymentMethodService;
    private ContractTypeService contractTypeService;
    private HiringCompanyService hiringCompanyService;
    private HiringCompanyEmployeeService hiringCompanyEmployeeService;
    private ContractedCompanyService contractedCompanyService;
    private ContractedCompanyEmployeeService contractedCompanyEmployeeService;
    private InstallmentService installmentService;
    private ContractItemService contractItemService;

    @GetMapping
    public List<Contract> getAllContracts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = service.findById(id);
        return contract.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contract createContract(@RequestBody ContractFormDTO contractFormDTO) {
        ContractType contractType = contractTypeService.findById(contractFormDTO.getContractTypeId()).orElse(null);
        PaymentMethod paymentMethod = paymentMethodService.findById(contractFormDTO.getPaymentMethodId()).orElse(null);
        HiringCompany subsidiaryCompany = hiringCompanyService.findById(contractFormDTO.getSubsidiaryCompanyId()).orElse(null);
        HiringCompanyEmployee contractManager = hiringCompanyEmployeeService.findById(contractFormDTO.getContractManagerId()).orElse(null);
        ContractedCompany contractedCompany = contractedCompanyService.findById(contractFormDTO.getContractedCompanyId()).orElse(null);
        ContractedCompanyEmployee legalRepresentative = contractedCompanyEmployeeService.findById(contractFormDTO.getLegalRepresentativeId()).orElse(null);

        Contract contract = service.save(contractFormDTO, contractType, paymentMethod, subsidiaryCompany, contractManager, contractedCompany, legalRepresentative);

        if (contractFormDTO.getContractItems() != null) {
            contractItemService.createContractContractItems(contractFormDTO.getContractItems(), contract);
        }

        installmentService.createContractInstallments(contract);

        return contract;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
