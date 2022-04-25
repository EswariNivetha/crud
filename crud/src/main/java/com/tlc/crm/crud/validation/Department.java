package com.tlc.crm.crud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartmentValidator.class)
@Documented
public @interface Department {

    String message() default "i18n_validator_error_invalid_name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}