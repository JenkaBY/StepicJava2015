package module4.lesson3.step8;

import java.util.logging.*;

/**
 * Created by YKuzmich on 04.12.2015.
 *
 * В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

 Требуется выставить такие настройки, чтобы:

 Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
 Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
 Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
 Не упомянутые здесь настройки изменяться не должны.

 (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.
 *
 */
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

    }
    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        Logger logger = Logger.getLogger("org.stepic.java");

        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);

        Handler consoleHandler = new ConsoleHandler();

        Formatter xmlFormatter = new XMLFormatter();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(xmlFormatter);
        logger.addHandler(consoleHandler);

        logger.setUseParentHandlers(false);
    }
}
