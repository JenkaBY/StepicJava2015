package module2.lesson2.step3;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a:
 * <p>
 * В качестве примера написано заведомо неправильное выражение. Исправьте его.
 * Sample Input 1:
 * 32
 * Sample Output 1:
 * |
 * <p>
 * Sample Input 2:
 * 12
 * Sample Output 2:
 * h
 */
public class Main {
    public char charExpression(int a) {
        char chrSLash = '\\';
        int slash = (int) chrSLash;
        return (char) (chrSLash + a);
    }
}
