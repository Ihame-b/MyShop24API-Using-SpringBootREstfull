package Student;

public class StudentNotFoundException extends  RuntimeException {

    StudentNotFoundException(Long id){
        super( String.format(" Student %s not found in our records", id));
    }
}
