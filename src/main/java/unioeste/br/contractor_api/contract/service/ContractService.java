package unioeste.br.contractor_api.contract.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contract.domain.dto.ContractFormDTO;
import unioeste.br.contractor_api.contract.domain.entity.Contract;
import unioeste.br.contractor_api.contract.repository.ContractRepository;
import unioeste.br.contractor_api.contractType.model.ContractType;
import unioeste.br.contractor_api.company.contractedCompany.domain.entity.ContractedCompany;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.company.hiringCompany.domain.entity.HiringCompany;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import unioeste.br.contractor_api.paymentMethod.model.PaymentMethod;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ContractService {
    private ContractRepository repository;

    public Page<Contract> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Contract> findById(Long id) {
        return repository.findById(id);
    }

    public String findByIdAsString(Long id) {
        Optional<Contract> optionalContract = repository.findById(id);
        return optionalContract.map(Contract::toString)
                .orElse("Desculpe mas não encontrei esse contrato!");
    }

    public String findByContractedCompanyIdAsString(Long id) {
        List<Contract> contracts = repository.findContractByContractedCompanyId(id);
        if (contracts.isEmpty()) {
            return "Não foi possível encontrar nenhum contrato para a empresa informada";
        }
        return "Aqui estão os dados dos contratos dessa empresa contratada:\n\n" +
                contracts.stream().map(Contract::toSummaryString).collect(Collectors.joining("\n\n"));
    }

    public String findBySubsidiaryCompanyIdAsString(Long id) {
        List<Contract> contracts = repository.findContractBySubsidiaryCompanyId(id);
        if (contracts.isEmpty()) {
            return "Não foi possível encontrar nenhum contrato para a empresa informada";
        }
        return "Aqui estão os dados dos contratos dessa empresa contratante:\n\n" +
                contracts.stream().map(Contract::toSummaryString).collect(Collectors.joining("\n\n"));
    }

    public String findAllAsString() {
        return "Aqui estão os dados dos contratos que constam no sistema:\n\n" +
                repository.findAll().stream()
                        .map(Contract::toSummaryString)
                        .collect(Collectors.joining("\n\n"));
    }

    public Contract save(ContractFormDTO contractFormDTO, ContractType contractType, PaymentMethod paymentMethod, HiringCompany subsidiaryCompany, HiringCompanyEmployee contractManager, ContractedCompany contractedCompany, ContractedCompanyEmployee legalRepresentative) {
        Contract contract = new Contract();
        contract.setName(contractFormDTO.getName());
        contract.setContractObjective(contractFormDTO.getContractObjective());
        contract.setStartDate(contractFormDTO.getStartDate());
        contract.setEndDate(contractFormDTO.getEndDate());
        contract.setContractedValue(contractFormDTO.getContractedValue());
        contract.setExecutionLocal(contractFormDTO.getExecutionLocal());
        contract.setLatitude(contractFormDTO.getLatitude());
        contract.setLongitude(contractFormDTO.getLongitude());
        contract.setContractType(contractType);
        contract.setPaymentMethod(paymentMethod);
        contract.setSubsidiaryCompany(subsidiaryCompany);
        contract.setContractManager(contractManager);
        contract.setContractedCompany(contractedCompany);
        contract.setLegalRepresentative(legalRepresentative);

        return repository.save(contract);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
