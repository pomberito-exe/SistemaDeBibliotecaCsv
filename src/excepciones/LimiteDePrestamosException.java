package excepciones;

public class LimiteDePrestamosException extends RuntimeException {
    public LimiteDePrestamosException(String message) {
        super(message);
    }
}
