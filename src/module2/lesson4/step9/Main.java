package module2.lesson4.step9;

import java.util.Arrays;

/**
 * Created by YKuzmich on 04.12.2015.
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный массив.
 * <p>
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
 * <p>
 * Пример
 * <p>
 * На вход подаются массивы {0, 2} и {1, 3}. На выходе должен получиться массив {0, 1, 2, 3}
 */
public class Main {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a = new int[a1.length + a2.length];
        for(int i = 0; i< a.length; i++ )
        {
            if(i <= a1.length-1) a[i] = a1[i];
            else a[i] = a2[i-a1.length];
        }
        Arrays.sort(a);

        return a; // your implementation here
    }
}
