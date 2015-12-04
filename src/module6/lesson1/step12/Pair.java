package module6.lesson1.step12;

/**
 * Created by YKuzmich on 28.10.2015.
 * ���������� generic-����� Pair, ������� �� Optional, �� ���������� ���� ��������� ������ ����� � �� �����������
 * ��������� ��������� �������� null.
 * <p>
 * ���������� ������ getFirst(), getSecond(), equals() � hashCode(), � ����� ����������� ��������� ����� of().
 * ����������� ������ ���� �������� (private).
 * <p>
 * � ��������� ������������� ������� Pair ������ ��������������� � ������� �������� ��������� ���:
 * <p>
 * Pair<Integer, String> pair = Pair.of(1, "hello");
 * Integer i = pair.getFirst(); // 1
 * String s = pair.getSecond(); // "hello"
 * <p>
 * Pair<Integer, String> pair2 = Pair.of(1, "hello");
 * boolean mustBeTrue = pair.equals(pair2); // true!
 * boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
 * <p>
 * <p>
 * ����������, �� ������� ����������� ������� ������ Pair. ��� ���������� �������� ����� ������ ����� �������� ���������.
 */
class Pair<M, N> {
    //private static final Pair<?, ?> EMPTY = new Pair<>();
    private final M valueM;
    private final N valueN;

    private Pair() {
        this.valueM = null;
        this.valueN = null;
    }

    /*public static<M,N> Pair<M,N> empty(){
        @SuppressWarnings("unchecked")
        Pair<M,N> mn = (Pair<M,N>) EMPTY;
        return mn;
    }*/

    private Pair(M valueM, N valueN) {
        this.valueM = valueM;
        this.valueN = valueN;
    }

    public static<M,N> Pair<M, N> of(M valueM1, N valueN1) {
        return new Pair<>(valueM1, valueN1);
    }

    public M getFirst() {
        return this.valueM;
    }

    public N getSecond() {
        return this.valueN;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        Pair<M, N> otherPair = (Pair<M, N>) obj;
        if (valueM != null ? !valueM.equals(otherPair.getFirst()) : otherPair.getFirst() != null) return false;
        return !(valueN != null ? !valueN.equals(otherPair.getSecond()) : otherPair.getSecond() != null);
    }
    @Override
    public int hashCode(){
        return valueM.hashCode()+valueN.hashCode();
    }
}
