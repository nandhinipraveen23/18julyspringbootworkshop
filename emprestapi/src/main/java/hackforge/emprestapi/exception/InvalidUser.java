package hackforge.emprestapi.exception;

public class InvalidUser extends  RuntimeException{
    public  InvalidUser(String err)
    {
        super(err);
    }
}
