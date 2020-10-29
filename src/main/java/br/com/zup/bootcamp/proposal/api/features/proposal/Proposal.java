package br.com.zup.bootcamp.proposal.api.features.proposal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private String socialIdentity;

    private String email;

    private String name;

    private String address;

    private BigDecimal salary;


    @Deprecated
    public Proposal() {
    }
}
