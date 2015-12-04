package module4.lesson3.step9;

import module4.lesson3.step9.stepicPackage.MailService;
import module4.lesson3.step9.stepicPackage.RealMailService;
import module4.lesson3.step9.stepicPackage.Sendable;

/**
 * Created by Jenka on 12.10.2015.
 *
 * UntrustworthyMailWorker � �����, ������������ ����������� ��������� �����, ������� ������ ����,
 * ����� �������� �������� ������ ��������������� � ������ �����, ��������������� �������� ���� ������ ������ ������� ���,
 * � �����, � ����� ������, �������� ������������ ������ ��������������� ���������� RealMailService.
 * � UntrustworthyMailWorker ������ ���� ����������� �� ������� MailService ( ��������� ������ processMail ������� �������� �������
 * ���������� �� ���� processMail ������� ��������, � �. �.) � ����� getRealMailService, ������� ���������� ������
 * �� ���������� ��������� RealMailService.
 *
 */
public class UntrustworthyMailWorker implements MailService {
    MailService[] mailServices=null;
    RealMailService realMailService=new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices){
        this.mailServices = mailServices;
    }

    public RealMailService getRealMailService(){
        return this.realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail)  {
        Sendable someMail = mail;
        for (int i = 0; i < this.mailServices.length; i++) {
            someMail = this.mailServices[i].processMail(someMail);
        }
        return realMailService.processMail(someMail);
    }
}
