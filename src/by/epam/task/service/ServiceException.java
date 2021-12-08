package by.epam.task.service;

public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {//wrappering
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
