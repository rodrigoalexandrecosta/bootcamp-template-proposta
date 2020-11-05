package br.com.zup.bootcamp.proposal.api.features.biometry;

import br.com.zup.bootcamp.proposal.api.features.creditcard.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "biometry")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Biometry {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    private String biometryData;

    private OffsetDateTime createdAt;

    @ManyToOne
    private CreditCard creditCard;


    @Deprecated
    public Biometry() {
    }
}
