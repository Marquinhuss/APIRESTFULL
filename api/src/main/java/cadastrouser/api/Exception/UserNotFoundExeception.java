package cadastrouser.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundExeception extends RuntimeException{

    public UserNotFoundExeception(String mensagem){
        super(mensagem);
    }
}
