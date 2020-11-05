package br.com.zup.bootcamp.proposal.api.features.biometry.resource;

import br.com.zup.bootcamp.proposal.api.features.biometry.Biometry;
import br.com.zup.bootcamp.proposal.api.features.biometry.resource.validation.Base64Biometry;
import br.com.zup.bootcamp.proposal.api.features.creditcard.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
@Setter
public class BiometryRequest {

    @NotBlank
    @Base64Biometry
    private String biometryData;

    @Deprecated
    public BiometryRequest() {
    }

    public Biometry toBiometry(final CreditCard creditCard) {
        return Biometry.builder()
                .biometryData(this.biometryData)
                .creditCard(creditCard)
                .createdAt(OffsetDateTime.now())
                .build();
    }
}
