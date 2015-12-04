package module2.lesson2.step9;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
 * <p>
 * Если для решения задачи вам требуются циклы или условные операторы, то можете вернуться к ней после просмотра соответствующих уроков. Хотя решить можно и без них.
 * <p>
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
 * <p>
 * Sample Input 1:
 * 0
 * Sample Output 1:
 * false
 * <p>
 * Sample Input 2:
 * 1
 * Sample Output 2:
 * true
 * <p>
 * Sample Input 3:
 * -2
 * Sample Output 3:
 * true
 */
public class Main {
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {

        return value != 0 && (((value & (-1) + value ^ (-1)) == -1) || ((-value & (-1) - value ^ (-1)) == -1)); // you implementation here
    }
}
