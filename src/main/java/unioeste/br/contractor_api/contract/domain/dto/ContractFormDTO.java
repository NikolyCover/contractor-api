package unioeste.br.contractor_api.contract.domain.dto;

import lombok.*;
import unioeste.br.contractor_api.contractItem.domain.dto.ContractItemFormDTO;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ContractFormDTO {
    private String name;
    private Long contractTypeId;
    private String contractObjective;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double contractedValue;
    private Long paymentMethodId;
    private String executionLocal;
    private Double latitude;
    private Double longitude;
    private Long subsidiaryCompanyId;
    private Long contractManagerId;
    private Long contractedCompanyId;
    private Long legalRepresentativeId;

    private List<ContractItemFormDTO> contractItems;
}
