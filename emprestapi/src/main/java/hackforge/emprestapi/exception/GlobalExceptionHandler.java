package hackforge.emprestapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ResponseMsg> studentNotFoundHandler(StudentNotFoundException ex)
    {
        ResponseMsg msg = new ResponseMsg(ex.getMessage());
        return ResponseEntity.badRequest().body(msg);
    }

    @ExceptionHandler(InvalidUser.class)
    public ResponseEntity<ResponseMsg> userNotFoundHandler(InvalidUser ex)
    {
        ResponseMsg msg = new ResponseMsg(ex.getMessage());
        return ResponseEntity.badRequest().body(msg);
    }
}
