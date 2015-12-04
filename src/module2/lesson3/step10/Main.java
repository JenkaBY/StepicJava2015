package module2.lesson3.step10;

import java.util.ArrayList;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая). При определении "палиндромности" строки должны учитываться только буквы и цифры. А пробелы, знаки препинания, а также регистр символов должны игнорироваться.

 Если в вашем решении требуются циклы и условные операторы, можете вернуться к этой задаче после просмотра соответствующего урока. Но решить можно и без них.

 Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

 Sample Input:
 Madam, I'm Adam!
 Sample Output:
 true

 *
 */
public class Main {
    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        text = text.toLowerCase();
        char[] ar = text.toCharArray();
        ArrayList<Character> arListChar = new ArrayList<>();
        for (char chr: ar) {
            if (Character.isLetterOrDigit(chr)){
                arListChar.add(chr);
            }
        }
        int countEqual=0;
        for (int i = 0; i < arListChar.size() /2; i++) {
            if (arListChar.get(i).equals(arListChar.get(arListChar.size()-1-i)))
            {
                countEqual++;
            }
        }
        return countEqual == arListChar.size()/2; // your implementation here
    }
}
