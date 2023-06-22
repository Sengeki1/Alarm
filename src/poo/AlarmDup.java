package poo;

public class AlarmDup extends Throwable {
    private String description;
    public String getMessage() {
        return "Already exist: " + description;
    }
}
