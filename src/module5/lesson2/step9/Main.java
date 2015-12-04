package module5.lesson2.step9;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле. На Unix-системах конец строки обозначается символом с кодом 10 ('\n'), на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').
 * <p>
 * Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix. Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out. На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.
 * <p>
 * Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'. Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.
 * <p>
 * Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13. Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.
 * <p>
 * Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush(). Иначе часть выведенных вами данных не будет видна проверяющей системе.
 * <p>
 * Пример
 * <p>
 * Из System.in зачитаны следующие байты: 65 13 10 10 13. Внимание! Это не строка "65 13 10 10 13", а последовательность чисел, возвращаемая методом System.in.read().
 * <p>
 * В System.out должны быть выведены байты: 65 10 10 13
 */

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Byte> inputBytes = new ArrayList<Byte>();
        int is;
        InputStream inS = System.in;
        OutputStream outS = new BufferedOutputStream(System.out);
        while ((is = inS.read()) != -1) {
            inputBytes.add((byte) is);
        }
        for (int i = 0; i < inputBytes.size(); i++) {
            if (inputBytes.get(i) == 13) {
                if (i != inputBytes.size() - 1 && inputBytes.get(i + 1) == 10) {
                    continue;
                } else outS.write(inputBytes.get(i));
            } else {
                outS.write(inputBytes.get(i));
            }
        }
        outS.flush();
        outS.close();
    }
}

