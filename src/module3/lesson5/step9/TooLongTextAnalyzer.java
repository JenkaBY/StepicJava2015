package module3.lesson5.step9;

/**
 * Created by asu7 on 06.10.2015.
 *
 * ������� ������� ����������� ����� ���������� ������ �� ������� ����� � ������������ ����� �����������.
 *
 * TooLongTextAnalyzer ������ ���������������� �� int'� � ������������ ���������� ������ �����������.
 * ������ ����� ������ ������ ��������� � ����� ��������� ��� ����� � ��������� ���� maxLength.
 *
 */
class TooLongTextAnalyzer implements TextAnalyzer  {
    private  int maxLength;

    public TooLongTextAnalyzer(int maxLenght){
        this.maxLength = maxLenght;
    }

    @Override
    public Label processText(String text) {
        return text.length()<=this.maxLength? Label.OK : Label.TOO_LONG;
    }
}
