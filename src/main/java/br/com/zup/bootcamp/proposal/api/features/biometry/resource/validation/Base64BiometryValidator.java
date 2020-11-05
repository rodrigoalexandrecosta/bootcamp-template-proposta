package br.com.zup.bootcamp.proposal.api.features.biometry.resource.validation;

import org.apache.commons.codec.binary.Base64;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Base64BiometryValidator implements ConstraintValidator<Base64Biometry, String> {

    @Override
    public void initialize(Base64Biometry annotation) {
    }

    @Override
    public boolean isValid(String biometryData, ConstraintValidatorContext context) {
        return !biometryData.isBlank() && Base64.isBase64(biometryData);
    }
}
