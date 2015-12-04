package module4.lesson2.step7;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Вспомним нашего старого знакомого робота из этой задачи. Теперь мы будем давать роботу команды удаленно, подключаясь к нему по беспроводному каналу связи.
 * <p>
 * Подключение к роботу представляется в программе интерфейсом RobotConnection:
 * <p>
 * public interface RobotConnection extends AutoCloseable {
 * void moveRobotTo(int x, int y);
 *
 * @Override void close();
 * }
 * Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку (метод moveRobotTo). Ему больше не нужны пошаговые инструкции.
 * RobotConnection — это временно устанавливаемое соединение, которое надо закрывать, когда оно больше не нужно. Для закрытия соединения в интерфейсе есть метод close().
 * <p>
 * За установку соединения отвечает RobotConnectionManager:
 * <p>
 * public interface RobotConnectionManager {
 * RobotConnection getConnection();
 * }
 * Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение, через которое можно отдавать роботу команды.
 * Установка соединения может завершиться неуспешно, а также уже установленное соединение может внезапно разорваться. Всякое бывает. Поэтому любой метод RobotConnectionManager и RobotConnection может бросить непроверяемое исключение RobotConnectionException:
 * <p>
 * public class RobotConnectionException extends RuntimeException {
 * <p>
 * public RobotConnectionException(String message) {
 * super(message);
 * <p>
 * }
 * <p>
 * public RobotConnectionException(String message, Throwable cause) {
 * super(message, cause);
 * }
 * }
 * Ваша задача — реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение в заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.
 * <p>
 * При этом:
 * <p>
 * Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить метод RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
 * Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и выполняем вторую попытку. Если вторая тоже не удалась, то выполняется третья. После третьей неудачи метод должен бросить исключение RobotConnectionException.
 * Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно должно быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
 * Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException, метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом. Единственное, что метод должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.
 */
public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int numberTry = 0; //номер попытки
        boolean isSuccessConnection = false; // успешное соединение и передвижение
        RobotConnection robotConnection = null;
        while ((isSuccessConnection != true) & (numberTry < 3)) {

            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                isSuccessConnection = true;
            } catch (RobotConnectionException e) {
                isSuccessConnection = false;
            } catch (Throwable e1) {
                isSuccessConnection = false;
                throw e1;
            } finally {
                if (robotConnection != null) {
                    try {
                        robotConnection.close();
                    } catch (RobotConnectionException e3) {
                        //throw e3;
                    } finally {
                        if (isSuccessConnection == false) numberTry++;
                    }
                } else numberTry++;
            }
        }
        if ((isSuccessConnection == false) & (numberTry == 3)) {
            throw new RobotConnectionException("Connection failure");
        }
    }
}
