package hackforge.emprestapi.exception;

public class StudentNotFoundException extends  RuntimeException{

    public StudentNotFoundException(String err){
        super(err);
    }

}
