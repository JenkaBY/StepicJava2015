package module3.lesson5.step9;
/**
 * Created by asu7 on 06.10.2015.
 *
 *  ���� ����� ����������� �� ������� ��������� �������� ���� � ������.
 *
 * SpamAnalyzer ������ ���������������� �� ������� ����� � ��������� �������.
 * ������ ����� ������ ������ ��������� � ����� ��������� ���� ������ ����� � ��������� ���� keywords.
 * ��������, �� ����� ����������� ����, ����������� � ���������� ����������� � ������� ������� �����������.
 *
 */
    class SpamAnalyzer extends KeywordAnalyzer /*implements TextAnalyzer */ {

    private String[] keywords = new String[]{":(","=(",":|"};
    private Label label;

    public SpamAnalyzer(String[] keywords){
        this.keywords = new String[keywords.length];
        this.keywords = keywords;
    }

    @Override
    public Label processText(String text) {
        if (super.processText(text) != Label.OK)
        {
            this.label = Label.SPAM;
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
