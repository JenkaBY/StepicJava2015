package module2.lesson1.step12;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
 * Погрешность вычислений – 0.0001 (1E-4)
 * <p>
 * В качестве примера написано заведомо неправильное выражение. Исправьте его.
 * Sample Input:
 * 0.1 0.2 0.3
 * Sample Output:
 * true
 */
public class Main {
    public boolean doubleExpression(double a, double b, double c) {
        double eps = 0.0001;

        return Math.abs(a + b - c) <= eps;
    }
}
