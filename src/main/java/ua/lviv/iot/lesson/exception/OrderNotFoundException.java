package ua.lviv.iot.lesson.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
    }
    public OrderNotFoundException(String message) {
        super(message);
    }
}
