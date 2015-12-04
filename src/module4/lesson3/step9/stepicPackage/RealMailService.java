package module4.lesson3.step9.stepicPackage;

/*
�����, � ������� ������ ������ ��������� �����
*/
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // ����� ������ ��� ��������� ������� �������� �����.
        return mail;
    }
}
