package dao;

public class DaoException extends Exception{
    private String message;

    public DaoException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
