package cadastrouser.api.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cadastrouser.api.Exception.UserNotFoundExeception;
import cadastrouser.api.View.Model.Error.ErrorMessage;

@ControllerAdvice
public class RestNotFoundHandler {
    
    @ExceptionHandler(UserNotFoundExeception.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundExeception ex){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
