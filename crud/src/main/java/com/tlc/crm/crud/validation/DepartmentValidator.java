package com.tlc.crm.crud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validates the department data.
 *
 * @author EswariNivethaVU
 */
public class DepartmentValidator implements ConstraintValidator<Department, String> {

    /**
     * Checks if the given value is valid or not.
     *
     * @param department
     * @param constraintValidatorContext
     */
    @Override
    public boolean isValid(final String department, final ConstraintValidatorContext constraintValidatorContext) {
        return (department.matches("(?i)it|cse|ece|eee|mech"));
    }
}
