package usixmlpatterns.Exceptions;

/**
 *
 * @author André Barbosa
 */
public class ActionNotSupportedException extends Exception {

    public ActionNotSupportedException() {
        super();
    }

    public ActionNotSupportedException(String message) {
        super(message);
    }

    public ActionNotSupportedException(Throwable cause) {
        super(cause);
    }

    public ActionNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

}
