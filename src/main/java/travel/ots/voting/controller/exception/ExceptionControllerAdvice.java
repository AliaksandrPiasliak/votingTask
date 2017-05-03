package travel.ots.voting.controller.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jms.IllegalStateException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import travel.ots.voting.service.exception.EntityNotFoundException;
import travel.ots.voting.service.exception.OptionsNotFoundException;

/**
 * ExceptionControllerAdvice - class that handles all exceptions that occur in the controllers.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     *
     * @param code Error code.
     * @param message Short message of the error.
     * @param text Text of the error.
     * @return details of the exception.
     */
    private ExceptionDetails setExceptionDetails(Integer code, String message, String text){
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setErrorCode(code);
        exceptionDetails.setShortMessage(message);
        exceptionDetails.setErrorText(text);
        return exceptionDetails;
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ExceptionDetails> handleDataAccessException(DataAccessException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleEntityNotFoundException(EntityNotFoundException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(OptionsNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleOptionsNotFoundException(OptionsNotFoundException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ExceptionDetails> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
                HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ExceptionDetails> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.NOT_ACCEPTABLE.value(),
                HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionDetails> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.METHOD_NOT_ALLOWED.value(),
                HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionDetails> handleIllegalStateException(IllegalStateException e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param e - object that contains information about exception.
     * @return http status of the response and exception message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleDefaultException(Exception e){
        ExceptionDetails exceptionDetails = setExceptionDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

}
