package travel.ots.voting.controller.exception;

import java.util.Objects;

/**
 * ExceptionDetails class that contains information about the application errors.
 */
public class ExceptionDetails {

    private Integer errorCode;
    private String shortMessage;
    private String errorText;

    /**
     * Default constructor of {@code ExceptionDetails} object.
     */
    public ExceptionDetails(){

    }

    /**
     *
     * @param code Error code.
     * @param message Short message of the error.
     * @param text Text of the error.
     */
    public ExceptionDetails(Integer code, String message, String text){
        this.errorCode = code;
        this.shortMessage = message;
        this.errorText = text;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExceptionDetails that = (ExceptionDetails) o;

        if (getErrorCode() != null ? !getErrorCode().equals(that.getErrorCode()) : that.getErrorCode() != null) {
            return false;
        }
        if (getShortMessage() != null ? !getShortMessage().equals(that.getShortMessage()) : that.getShortMessage() != null) {
            return false;
        }
        return getErrorText() != null ? getErrorText().equals(that.getErrorText()) : that.getErrorText() == null;

    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, shortMessage, errorText);
    }

    @Override
    public String toString() {
        return "ExceptionDetails{" +
                "errorCode=" + errorCode +
                ", shortMessage='" + shortMessage + '\'' +
                ", errorText='" + errorText + '\'' +
                '}';
    }
}
