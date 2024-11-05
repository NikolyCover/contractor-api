package unioeste.br.contractor_api.company.hiringCompany.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.company.base.domain.entity.Company;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class HiringCompany extends Company {
    private boolean matrix;

    @Override
    public String toString() {
        return super.toString() + String.format("\nMatriz: %s", matrix ? "Sim" : "Não");
    }
}
