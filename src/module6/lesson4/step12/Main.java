package module6.lesson4.step12;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Created by YKuzmich on 04.12.2015.
 * Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

 Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

 minMaxConsumer.accept(min, max);
 Если стрим не содержит элементов, то вызовите
 minMaxConsumer.accept(null, null);
 */
public class Main {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Object[] objects = stream.sorted(order).toArray();
        T[] tobjects = (T[]) objects;
        if (objects.length == 0) {
            minMaxConsumer.accept(null, null);
        }
        else minMaxConsumer.accept((T)tobjects[0],(T) tobjects[tobjects.length - 1]);
    }
}
