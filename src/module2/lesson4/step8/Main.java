package module2.lesson4.step8;

import java.math.BigInteger;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод, вычисляющий факториал заданного натурального числа.
 * <p>
 * Факториал N вычисляется как 1⋅2⋅...⋅N.
 * <p>
 * Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.
 * <p>
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
 * <p>
 * Sample Input 1:
 * 1
 * Sample Output 1:
 * 1
 * <p>
 * Sample Input 2:
 * 3
 * Sample Output 2:
 * 6
 */
public class Main {
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger bi = new BigInteger("1");

        for (int i = 1; i <= value; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        return bi; // your implementation here
    }
}

