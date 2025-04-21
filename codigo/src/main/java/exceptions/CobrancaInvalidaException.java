package exceptions;

public class CobrancaInvalidaException extends RuntimeException {
    public CobrancaInvalidaException(String message) {
        super(message);
    }

    public CobrancaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}