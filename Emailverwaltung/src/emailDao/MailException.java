package emailDao;

public class MailException extends Exception{
    private String message;

    public MailException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
