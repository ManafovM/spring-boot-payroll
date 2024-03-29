package payroll.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long id) {
        super("Could not find order" + id);
    }
}
