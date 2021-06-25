package dao;

public class DaoException extends Exception{
    private String message;

    /**
     * Konstrucker
     *
     * @param message Der Fehlertext
     */

    public DaoException(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
