package be.atc.warehousemgmt.web.controller.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author aidoumhaidi
 * @since 15/04/16
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSResponse {

    private boolean success;
    private String message;

    public JSResponse() {
    }

    public JSResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static JSResponse of(boolean success, String message) {
        return new JSResponse(success, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
