package travel.ots.voting.service.exception;

/**
 * OptionsNotFoundException extends RuntimeException - this class
 * responsible for exceptions that occurs when options for voting not found.
 */
public class OptionsNotFoundException extends RuntimeException {

    /**
     *
     * @param message the detail message
     */
    public OptionsNotFoundException(String message){
        super(message);
    }

    /**
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public OptionsNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     *
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     * @param enableSuppression whether or not suppression is enabled or disabled.
     * @param writableStackTrace whether or not the stack trace should be writable.
     */
    public OptionsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

    /**
     *
     * @param cause the cause of the exception.
     */
    public OptionsNotFoundException(Throwable cause){
        super(cause);
    }
}
