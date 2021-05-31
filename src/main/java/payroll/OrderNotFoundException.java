package payroll;

public class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException(long id) {
        super("Could not find order" + id);
    }
}
