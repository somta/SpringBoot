package net.somta.springboot.i18n.enums;

import net.somta.core.base.IBaseError;

public enum AccountErrorEnum implements IBaseError {
    ACCOUNT_TYPE(1000,  "account.accountType"),
    ;

    private int errorCode;
    private String errorMsg;

    AccountErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public long getErrorCode() {
        return 100000L + errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}