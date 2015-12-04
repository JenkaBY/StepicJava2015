package module4.lesson3.step9;

import module4.lesson3.step9.stepicPackage.MailMessage;
import module4.lesson3.step9.stepicPackage.MailService;
import module4.lesson3.step9.stepicPackage.Sendable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jenka on 12.10.2015.
 * <p/>
 * <p/>
 * Spy � �����, ������� ��������� � ���� �������� ���������, ������� �������� ����� ��� ����. ������ �������������� �� ���������� Logger,
 * � ������� �������� ����� ����� �������� � ���� ���������. �� ������ ������ �� ��������� ������ MailMessage �
 * ����� � ������ ��������� ��������� (� ���������� ����� �������� ����� � �������� ������� �� �������� ����� �����):
 * 2.1) ���� � �������� ����������� ��� ���������� ������ "Austin Powers", �� ����� �������� � ��� ���������
 * � ������� WARN: Detected target mail correspondence: from {from} to {to} "{message}"
 * 2.2) �����, ���������� �������� � ��� ��������� � ������� INFO: Usual correspondence: from {from} to {to}
 */
public class Spy implements MailService {
    protected static Logger spy = null;

    public Spy(Logger logger) {
        spy = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            if (mail.getFrom().equals(Person.AUSTIN_POWERS) || mail.getTo().equals(Person.AUSTIN_POWERS)) {
                spy.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\""
                        , new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            } else spy.log(Level.INFO, "Usual correspondence: from {0} to {1}"
                    , new Object[]{mail.getFrom(), mail.getTo()});
        }


        return mail;
    }
}
