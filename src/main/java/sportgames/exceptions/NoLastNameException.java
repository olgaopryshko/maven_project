package sportgames.exceptions;

public class NoLastNameException extends Exception {
    @Override
    public String getMessage() {
        return "Please, enter player's last name";
    }
}


