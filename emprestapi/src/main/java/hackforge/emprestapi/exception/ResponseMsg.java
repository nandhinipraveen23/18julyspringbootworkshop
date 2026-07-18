package hackforge.emprestapi.exception;

public class ResponseMsg {
    String msg;
    public ResponseMsg(String msg)
    {
        this.msg=msg;
    }

    public  void setMsg(String msg)
    {
        this.msg=msg;

    }

    public String getMsg()
    {
        return msg;

    }
}
