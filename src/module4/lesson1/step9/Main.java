package module4.lesson1.step9;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(), это метод при передаче
 * отрицательного параметра должен бросать исключение java.lang.IllegalArgumentException
 * с сообщением "Expected non-negative number, got ?", где вместо вопросика будет подставлено
 * фактически переданное в метод число.
 */
public class Main {
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }

        return Math.sqrt(x); // your implementation here
    }
}
