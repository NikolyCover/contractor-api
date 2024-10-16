package unioeste.br.contractor_api.installment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Installment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    private LocalDate scheduledDeliveryDate;

    private LocalDate paymentDate;

    private Boolean paymentReceipt;
}
