package br.com.zup.bootcamp.proposal.api.features.proposal;

import br.com.zup.bootcamp.proposal.api.features.analysis.ProposalAnalysisRequest;
import br.com.zup.bootcamp.proposal.api.features.creditcard.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "proposal")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Proposal {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @NotBlank
    private String socialIdentity;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    @PositiveOrZero
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private ProposalStatus status;

    @OneToOne(mappedBy = "proposal")
    private CreditCard creditCard;


    @Deprecated
    public Proposal() {
    }

    public ProposalAnalysisRequest toAnalysisRequest() {
        return new ProposalAnalysisRequest(this.socialIdentity, this.name, this.id.toString());
    }

}
