package module2.lesson1.step15;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
 * <p>
 * Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).
 * <p>
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
 * <p>
 * Sample Input:
 * 0 1
 * Sample Output:
 * 1
 */
public class Main {
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        int logic = 1 << (bitIndex - 1) & value;
        //System.out.println("SHIFT " + Integer.toString(1<<(bitIndex-1),2));
        int newValue;
        if (logic > 0) newValue = value - 1 << (bitIndex - 1);
        else newValue = value + 1 << (bitIndex - 1);
        return newValue; // put your implementation here

    }
}
