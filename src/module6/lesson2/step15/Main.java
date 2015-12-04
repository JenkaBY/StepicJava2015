package module6.lesson2.step15;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.

 Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

 В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

 Sample Input:
 1 2 3 4 5 6 7
 Sample Output:
 6 4 2
 *
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputSet = new ArrayList<Integer>();
        int odd = 0;
        while (sc.hasNext()) {
            try {
                if (odd % 2 == 0) {
                    sc.next();
                } else {inputSet.add(Integer.parseInt(sc.next()));}
                odd++;
            } catch (NumberFormatException e) {
            }
        }
        Collections.reverse(inputSet);
        for (int i = 0; i < inputSet.size(); i ++) {
            System.out.print(inputSet.get(i));
            if (i == inputSet.size()-1 ) System.out.print("");
            else System.out.print(" ");
        }
    }
}
