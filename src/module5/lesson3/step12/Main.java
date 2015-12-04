package module5.lesson3.step12;
import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

 Пример

 InputStream последовательно возвращает четыре байта: 48 49 50 51.

 Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
 *
 */
public class Main {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int chr;
        StringBuilder sb= new StringBuilder();
        while ((chr = reader.read())!=-1){
            sb.append((char)chr);
        }

        return sb.toString();
    }
}
