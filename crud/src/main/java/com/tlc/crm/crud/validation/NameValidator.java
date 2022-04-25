package com.tlc.crm.crud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validates the name.
 *
 */
public class NameValidator implements ConstraintValidator<Name, String> {

    /**
     * Validates name.
     *
     * @param name
     * @param constraintValidatorContext
     */
    @Override
    public boolean isValid(final String name, final ConstraintValidatorContext constraintValidatorContext) {
        return name.matches("[a-zA-Z\\s]*$");
    }
}
