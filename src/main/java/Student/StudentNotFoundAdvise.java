package Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class StudentNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
   String studentNotFoundHandler( StudentNotFoundException ex){
     return ex.getMessage();
    }
}
