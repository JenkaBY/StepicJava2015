package module3.lesson4.step9;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

 Реализация hashCode(), возвращающая константу, засчитана не будет

 Пример

 ComplexNumber a = new ComplexNumber(1, 1);
 ComplexNumber b = new ComplexNumber(1, 1);
 // a.equals(b) must return true
 // a.hashCode() must be equal to b.hashCode()

 P.S. Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет сама генерировать equals() и hashCode(). Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно выглядит именно так. Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode() для какого-нибудь простого класса, то среда разработки помочь не сможет.
 *
 */
public class Main {

    public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }
        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj== null) return  false;
            if (getClass() != obj.getClass())
                return false;
            ComplexNumber other = (ComplexNumber) obj;
            if (getRe() != other.getRe())
                return false;
            if (getIm() != other.getIm())
                return false;
            return true;

        }

        @Override
        public  int hashCode()
        {
            final int key = 7;
            double result = 3;
            result = result*key + getRe();
            result  = result*key+getIm();
            return (int)result;
        }
    }
}
