package com.tlc.crm.crud.validation;

import com.tlc.commons.code.ErrorCode;
import com.tlc.crm.crud.model.Student;
import com.tlc.crm.crud.status.StudentErrorCodes;
import com.tlc.validator.ModelValidator;
import com.tlc.validator.ValidatorAccess;

/**
 * Validates the input data.
 *
 * @author EswariNivethaVU
 */
public class HibernateValidation {

    private static final ModelValidator MODEL_VALIDATOR = ValidatorAccess.get();

    /**
     * Validates the Student Data.
     *
     * @param student
     * @param clazz
     */
    public static void validator(final Student student, final Class...clazz) {

        if (!MODEL_VALIDATOR.isValid(student, clazz)) {
            throw ErrorCode.get(StudentErrorCodes.INVALID_INPUT_DATA);
        }
    }
}
