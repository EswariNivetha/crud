package com.tlc.crm.crud.status;

import com.tlc.commons.code.ErrorCodeGroup;
import com.tlc.commons.code.ErrorCodeProvider;

/**
 * Error code implementation for student data.
 *
 * @author EswariNivethaVU
 */
public enum StudentErrorCodes implements ErrorCodeProvider {

    ID_NOT_FOUND(0x04),
    INVALID_INPUT_DATA(0x05);

    private final int code;

    StudentErrorCodes(final int code) {
        this.code = StudentErrorCodeGroup.ERROR_CODE.getConvertedCode(code);
    }

    /**
     * Gets the Student Error codes
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * Creates Error code group for student data.
     */
    private static class StudentErrorCodeGroup implements ErrorCodeGroup {

        private static final ErrorCodeGroup ERROR_CODE = new StudentErrorCodeGroup();

        @Override
        public int getPrefix() {
            return 0x10_0_0000;
        }
    }
}
