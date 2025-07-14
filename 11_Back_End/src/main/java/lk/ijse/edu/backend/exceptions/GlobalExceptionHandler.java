package lk.ijse.edu.backend.exceptions;

import lk.ijse.edu.backend.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/14/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handle all exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new APIResponse<>(500, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<APIResponse<String>> handleResourceNotFound(ResourceNotFound ex){
        return new ResponseEntity<>(new APIResponse<>( 404, "Resource Not Found", null),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });

        return new ResponseEntity<>(new APIResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                errors
        ),HttpStatus.BAD_REQUEST);

    }
}
