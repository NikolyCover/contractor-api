package unioeste.br.contractor_api.contractItem.domain.dto;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.contractItem.domain.entity.ContractItemType;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ContractItemFormDTO {

    private String name;

    @Enumerated(EnumType.STRING)
    private ContractItemType type;

    private LocalDate scheduledDate;
}
