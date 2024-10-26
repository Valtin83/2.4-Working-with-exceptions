import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class WrongLoginException extends Exception{

    // Конструктор по умолчанию

    public WrongLoginException(String message) {
        super(message);
    }

    // Метод проверки длины логина.

    public static void checkLogin(String login) throws WrongLoginException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Ошибка! Превышена длина логина.");
        }


        // Проверка на соответствие используемых символов.
        // Вызов исключения по ошибке ввода логина.

        CharacterIterator it = new StringCharacterIterator(login);
        while (it.current() != CharacterIterator.DONE) {
            if (it.current() < '0' | it.current() > '9' & it.current() < 'A' |
                    it.current() > 'Z' & it.current() < 'a' & it.current() != '_' | it.current() > 'z') {
                throw new WrongLoginException("Используются недопустимые для логина символы.");
            }
            it.next();
        }
    }
}

