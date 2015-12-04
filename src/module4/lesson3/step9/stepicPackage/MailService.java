package module4.lesson3.step9.stepicPackage;

import module4.lesson3.step9.IllegalPackageException;

/*
���������, ������� ������ �����, ������� ����� �����-���� ������� ���������� �������� ������.
*/
public interface MailService {
    Sendable processMail(Sendable mail) throws IllegalPackageException;
}

