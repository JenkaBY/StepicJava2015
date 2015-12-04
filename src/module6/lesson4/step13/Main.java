package module6.lesson4.step13;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.

 Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

 Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.

 Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

 Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

 Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

 Sample Input 1:
 Мама мыла-мыла-мыла раму!
 Sample Output 1:
 мыла
 мама
 раму

 Sample Input 2:
 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
 Sample Output 2:
 consectetur
 faucibus
 ipsum
 lorem
 adipiscing
 amet
 dolor
 eget
 elit
 mi
 *
 *
 */
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Charset charset = StandardCharsets.UTF_8;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, charset));
        bufferedReader.lines().flatMap(x -> Stream.of(x.split("[\\p{Blank}\\p{Punct}]+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                        (e0, e1) -> {
                            final int res = e1.getValue().compareTo(e0.getValue());
                            return res == 0 ? e0.getKey().compareTo(e1.getKey()) : res;
                        }
                )
                .limit(10)
                .forEach(x -> System.out.println(x.getKey()));
    }
}
