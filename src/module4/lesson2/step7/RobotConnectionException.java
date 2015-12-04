package module4.lesson2.step7;

/**
 * Created by asu7 on 12.10.2015.
 */
public class RobotConnectionException extends  RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
