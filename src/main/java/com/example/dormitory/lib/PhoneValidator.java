package com.example.dormitory.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {
    public static final String PHONE_VALIDATION_REGEX = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(PHONE_VALIDATION_REGEX);
    }
}
