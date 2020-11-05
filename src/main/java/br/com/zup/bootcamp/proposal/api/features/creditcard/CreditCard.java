package br.com.zup.bootcamp.proposal.api.features.creditcard;

import br.com.zup.bootcamp.proposal.api.features.biometry.Biometry;
import br.com.zup.bootcamp.proposal.api.features.proposal.Proposal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "credit_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    private String cardNumber;

    @OneToOne
    @JoinColumn(name = "proposal_id", referencedColumnName = "id")
    private Proposal proposal;

    @OneToMany(mappedBy = "creditCard")
    private List<Biometry> biometries;

    public CreditCard(String cardNumber, Proposal proposal) {
        this.cardNumber = cardNumber;
        this.proposal = proposal;
    }
}
