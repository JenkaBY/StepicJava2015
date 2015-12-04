package module4.lesson3.step9;

import module4.lesson3.step9.stepicPackage.MailPackage;
import module4.lesson3.step9.stepicPackage.MailService;
import module4.lesson3.step9.stepicPackage.Package;
import module4.lesson3.step9.stepicPackage.Sendable;

/**
 * Created by Jenka on 12.10.2015.
 * <p/>
 * Thief � ���, ������� ������ ����� ������ ������� � ���������� ��� ���������. ��� ��������� � ������������ ����������
 * int � ����������� ��������� �������, ������� �� ����� ��������. �����, � ������ ������ ������ �������������� ����� getStolenValue,
 * ������� ���������� ��������� ��������� ���� �������, ������� �� ��������.
 * ��������� ���������� ��������� �������: ������ �������, ������� ������ ����, �� ������ �����, ����� ��,
 * ������ � ������� ��������� � ���������� ������� "stones instead of {content}".
 */
public class Thief implements MailService {
    protected int stolenValue = 0;
    protected int minimalCost = 0;

    public Thief(int minimalCost) {
        this.minimalCost = minimalCost;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            if (((MailPackage) mail).getContent().getPrice() >= minimalCost) {
                stolenValue += ((MailPackage) mail).getContent().getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of "
                        + ((MailPackage) mail).getContent().getContent(), 0));
            }
            else return mail;
        } else return mail;
    }
}
