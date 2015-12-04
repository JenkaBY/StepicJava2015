package module4.lesson2.step7;

/**
 * Created by asu7 on 12.10.2015.
 */
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
