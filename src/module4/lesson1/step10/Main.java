package module4.lesson1.step10;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 * <p>
 * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода,
 * откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку,
 * а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа
 * в программу, т.е. его никто не вызывал.
 * Пример
 * <p>
 * package org.stepic.java.example;
 * <p>
 * public class Test {
 * public static void main(String[] args) {
 * System.out.println(getCallerClassAndMethodName());
 * anotherMethod();
 * }
 * <p>
 * private static void anotherMethod() {
 * System.out.println(getCallerClassAndMethodName());
 * }
 * <p>
 * public static String getCallerClassAndMethodName() {
 * // ...
 * }
 * }
 * При запуске эта программа должна вывести:
 * null
 * org.stepic.java.example.Test#main
 * P.S. При тестировании этой программы в среде разработки вы можете получить другой результат:
 * вместо null в первой строчке будет напечатан какой-то посторонний класс и метод.
 * Это связано с тем, что среда разработки обычно запускает не ваш класс, а свой собственный,
 * который затем уже вызывает ваш. Чтобы этого избежать, запускайте программу командой "java" в командной строке.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        //therMethod();
        anotherMethod();

    }
    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        //otherMethod();
    }
    private static void otherMethod() {
        System.out.println(getCallerClassAndMethodName());
        therMethod();
    }
    private static void therMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        Throwable thr = new Exception();
        StackTraceElement[] ste= thr.getStackTrace();
        int last = ste.length-1; //1;

        int len2 = 2;
        if (ste.length < 3) {
            return null;
        }
        else return  (ste[len2].getClassName() +"#"+ ste[len2].getMethodName());
    }
}
