package exceptions;

public class WrongDataException extends Exception {
    public WrongDataException() {
        super("Неверные данные");
    }
}
