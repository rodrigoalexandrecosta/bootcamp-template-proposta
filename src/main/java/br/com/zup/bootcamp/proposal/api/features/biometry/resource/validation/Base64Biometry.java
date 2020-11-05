package br.com.zup.bootcamp.proposal.api.features.biometry.resource.validation;

import javax.validation.Payload;

public @interface Base64Biometry {

    String message() default "{message.biometry.invalid-format}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
