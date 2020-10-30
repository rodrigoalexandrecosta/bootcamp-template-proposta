package br.com.zup.bootcamp.proposal.api.features.proposal.resource;

import br.com.zup.bootcamp.proposal.api.features.proposal.Proposal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProposalRequest {

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


    public Proposal toProposal() {
        return Proposal.builder()
                .socialIdentity(this.socialIdentity)
                .email(this.email)
                .name(this.name)
                .address(this.address)
                .salary(this.salary)
                .build();
    }
}
