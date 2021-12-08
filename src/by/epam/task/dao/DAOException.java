package by.epam.task.dao;

public class DAOException extends Exception {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {//wrappering
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
