package Exception;

/**
 * Exceptions for unrecognised commands
 */
public class InvalidCommandException extends Exception {

    private final String message;

    public InvalidCommandException(String s) {
        this.message = s;
    }

    /**
     * @return Exception Message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
