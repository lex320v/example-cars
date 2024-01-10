package example.car.exceptions;

public class PersonNotRegistration extends RuntimeException {
    public PersonNotRegistration(String msg) {
        super(msg);
    }
}