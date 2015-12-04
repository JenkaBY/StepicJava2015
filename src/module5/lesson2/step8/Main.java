package module5.lesson2.step8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by YKuzmich on 04.12.2015.
 * <p>
 * Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
 * <p>
 * Контрольная сумма данных вычисляется по следующему алгоритму:
 * <p>
 * Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
 * Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле: Cn+1=rotateLeft(Cn) xor bn+1 , где Cn — контрольная сумма первых n байт данных, rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед, используйте Integer.rotateLeft), bn — n-ный байт данных.
 * Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов InputStream исключение должно выбрасываться из метода.
 * <p>
 * Пример
 * На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01. В качестве контрольной суммы должно быть возвращено число 71.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        byte[] input = {0x33, 0x45, 0x01};
        InputStream inputStream = new ByteArrayInputStream(input);
        int result = checkSumOfStream(inputStream);
        System.out.println(result);
    }
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int b;
        int crc = 0;
        try {
            while ((b = inputStream.read()) != -1) {
                crc = Integer.rotateLeft(crc, 1) ^ b;
            }
        } catch (IOException e) {
            throw new IOException();
        }

        return crc;
    }
}

