package module3.lesson5.step9;

/**
 * Created by asu7 on 06.10.2015.
 *
 *  ���������� ���������� ����� ���������� �� ������� ������ �� ���� ��������� � :( =( :|
 *
 * NegativeTextAnalyzer ������ ���������������� ������������� ��-���������.
 *
 */
class NegativeTextAnalyzer extends KeywordAnalyzer/* implements TextAnalyzer*/ {
    private String[] keywords = new String[]{":(","=(",":|"};
    protected Label label;

    @Override
    public Label processText(String text) {
        if (super.processText(text) != Label.OK)
        {
            this.label = Label.NEGATIVE_TEXT;
            return this.getLabel();
        }
        else {
            this.label = Label.OK;
            return this.getLabel();
        }
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }

}