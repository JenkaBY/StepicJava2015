package module2.lesson1.step6;

/**
 * Created by YKuzmich on 04.12.2015.
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean booleanExpression(boolean a, boolean b, boolean c) {
        return ((c & secretFunction()) | (a ^ b));
    }

    public boolean secretFunction() {
        return true;
    }
}
