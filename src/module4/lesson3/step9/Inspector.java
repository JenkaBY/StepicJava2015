package module4.lesson3.step9;

import module4.lesson3.step9.stepicPackage.MailPackage;
import module4.lesson3.step9.stepicPackage.MailService;
import module4.lesson3.step9.stepicPackage.Sendable;

/**
 * Created by Jenka on 12.10.2015.
 * <p/>
 * Inspector � ���������, ������� ������ �� ������������ � ����������� ��������� � ���� ������� � ���� ����������,
 * ���� ���� ���������� �������� �������. ���� �� ������� ����������� ������� � ����� �� ����������� ����������
 * ("weapons" � "banned substance"), �� �� ������� IllegalPackageException. ���� �� ������� �������,
 * ��������� �� ������ (�������� ����� "stones"), �� ������� ��������� � ���� StolenPackageException.
 * ��� ���������� �� ������ �������� �������������� � ���� ������������� ����������.
 */
public class Inspector implements MailService {


    @Override
    /*throws IllegalPackageException,StolenPackageException*/
    public Sendable processMail(Sendable mail) throws IllegalPackageException,StolenPackageException {
        if (mail instanceof MailPackage) {
            if (((MailPackage) mail).getContent().getContent().equals(Person.WEAPONS)
                    || ((MailPackage) mail).getContent().getContent().equals(Person.BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            else if (((MailPackage) mail).getContent().getContent().contains("stones")){
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
