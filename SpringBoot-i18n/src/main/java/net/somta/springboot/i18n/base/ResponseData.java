package net.somta.springboot.i18n.base;

import net.somta.core.base.IBaseError;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import static net.somta.springboot.i18n.utils.I18nUtil.getI18nMessage;

public class ResponseData<T> {
    private boolean success;

    private String errorMsg;
    private T data;

    public static ResponseData setResponseData(Object data) {
        ResponseData r = new ResponseData();
        r.setSuccess(true);
        r.setData(data);
        return r;
    }

    public static ResponseData setErrorResponseData(IBaseError baseError) {
        ResponseData r = new ResponseData();
        r.setSuccess(false);
        r.setErrorMsg(getI18nMessage(baseError.getErrorMsg()));
        return r;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
