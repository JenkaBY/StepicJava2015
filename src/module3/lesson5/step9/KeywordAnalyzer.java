package module3.lesson5.step9;

/**
 * Created by asu7 on 06.10.2015.
 *
 * ������� ��� ����������� ������ getKeywords � getLabel, ���� �� ������� ����� ���������� ����� �������� ����,
 * � ������ �����, ������� ���������� �������� ������������� ������������.
 * ��� ������� ���������� ��� ������ ������������ �������, ������� ������� ������ � ��� ������ ��� �����������.
 *
 */
abstract class KeywordAnalyzer implements TextAnalyzer {

    @Override
    public Label processText(String text) {
        boolean boolLabel = false;
        for(String keyword: this.getKeywords())
        {
            if(text.contains(keyword))
            {
                boolLabel = true;
                break;
            }
        }
        return boolLabel ? Label.SPAM : Label.OK;
    }

   abstract protected String[] getKeywords();

    abstract protected Label getLabel();
}
