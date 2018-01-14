package by.vorobyov.training.exception;

public class ServiceException extends Exception {
    public ServiceException(Throwable e) {
        super(e);
    }

    public ServiceException(String message, Throwable e) {
        super(message, e);
    }
}
