package exceptions;

public class WrongDataException extends Exception {
    public WrongDataException() {
        super("Неправильный формат данных");
    }
}
