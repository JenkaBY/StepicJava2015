package module6.lesson2.step14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * Реализуйте метод, вычисляющий симметрическую разность двух множеств.

 Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

 Пример

 Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        Integer[] arInt1 = new Integer[]{1, 2, 3};
        Integer[] arInt2 = new Integer[]{0, 1, 2};

        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(arInt1));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(arInt2));

        Set<Integer> set3 = symmetricDifference(set1, set2);
        set3.forEach(System.out::println);
    }
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setSym = new HashSet<T>();
        Set<T> setTemp = new HashSet<T>();
        setTemp.addAll(set1);
        setTemp.addAll(set2);
        Iterator<T> iteratorForSetTemp = setTemp.iterator();
        while (iteratorForSetTemp.hasNext()) {
            T nextT = iteratorForSetTemp.next();
            if (set1.contains(nextT) && set2.contains(nextT)) continue;
            else setSym.add(nextT);
        }
        return setSym;
    }
}
