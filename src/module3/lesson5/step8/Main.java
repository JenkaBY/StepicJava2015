package module3.lesson5.step8;

import java.util.ArrayList;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

 Класс AsciiCharSequence должен:

 реализовывать интерфейс java.lang.CharSequence;
 иметь конструктор, принимающий массив байт;
 определять методы length(), charAt(), subSequence() и toString()
 Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

 В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

 P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254
 *
 */
public class Main {
    public static void main(String[] args)
    {
        byte[] asciiAll =new byte[128];
        for (int i = 0; i < 128; i++) {
            asciiAll[i] = (byte)i;
            //asciiAll[i]
        }

        AsciiCharSequence ascii = new AsciiCharSequence(asciiAll);
        System.out.println(ascii.toString());
    }

    public static class AsciiCharSequence implements CharSequence {
        private ArrayList<Byte> _charSequence = new ArrayList<Byte>();

        public AsciiCharSequence(byte[] bytes) {
            for (int i = 0; i < bytes.length; i++) {
                _charSequence.add(bytes[i]);
            }

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < _charSequence.size(); i++) {
                sb.append(this.charAt(i));
            }
            return sb.toString();
        }

        // implementation
        /**
         * Returns the length of this character sequence.  The length is the number
         * of 16-bit <code>char</code>s in the sequence.</p>
         *
         * @return the number of <code>char</code>s in this sequence
         */
        @Override
        public int length() {

            return _charSequence.size();
        }

        /**
         * Returns the <code>char</code> value at the specified index.  An index ranges from zero
         * to <tt>length() - 1</tt>.  The first <code>char</code> value of the sequence is at
         * index zero, the next at index one, and so on, as for array
         * indexing. </p>
         * <p/>
         * <p>If the <code>char</code> value specified by the index is a
         * <a href="{@docRoot}/java/lang/Character.html#unicode">surrogate</a>, the surrogate
         * value is returned.
         *
         * @param index the index of the <code>char</code> value to be returned
         * @return the specified <code>char</code> value
         * @throws IndexOutOfBoundsException if the <tt>index</tt> argument is negative or not less than
         *                                   <tt>length()</tt>
         */
        @Override
        public char charAt(int index) {
            return (char)(byte)_charSequence.get(index);
        }

        /**
         * Returns a new <code>CharSequence</code> that is a subsequence of this sequence.
         * The subsequence starts with the <code>char</code> value at the specified index and
         * ends with the <code>char</code> value at index <tt>end - 1</tt>.  The length
         * (in <code>char</code>s) of the
         * returned sequence is <tt>end - start</tt>, so if <tt>start == end</tt>
         * then an empty sequence is returned. </p>
         *
         * @param start the start index, inclusive
         * @param end   the end index, exclusive
         * @return the specified subsequence
         * @throws IndexOutOfBoundsException if <tt>start</tt> or <tt>end</tt> are negative,
         *                                   if <tt>end</tt> is greater than <tt>length()</tt>,
         *                                   or if <tt>start</tt> is greater than <tt>end</tt>
         */
        @Override
        public CharSequence subSequence(int start, int end) {
            //CharSequence tempCharSequence = new AsciiCharSequence(this._charSequence.toArray(byte[]));
            byte[] tempArrayByte = new byte[end-start];
            for (int i = 0; i < tempArrayByte.length; i++) {
                tempArrayByte[i] = this._charSequence.get(start+i);
            }
            return new AsciiCharSequence(tempArrayByte);
        }
    }
}


