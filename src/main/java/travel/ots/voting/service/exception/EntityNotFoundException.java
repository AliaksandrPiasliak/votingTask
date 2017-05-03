package travel.ots.voting.service.exception;

/**
 * EntityNotFoundException extends RuntimeException - this class
 * responsible for exceptions that occurs when data not found.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     *
     * @param message the detail message
     */
    public EntityNotFoundException(String message){
        super(message);
    }

    /**
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public EntityNotFoundException(String message, Throwable cause){
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
    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

    /**
     *
     * @param cause the cause of the exception.
     */
    public EntityNotFoundException(Throwable cause){
        super(cause);
    }
}
