import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Main {

    public static void main(String[] args) {

        String login = "java_skнpro_go"; // Логин
        String password = "D_1hWikjjP_9"; // Пароль
        String confirmPassword = "D_1hWikjjP_9"; // Повтор пароля

        boolean isLoginValid = true;
        boolean isPasswordValid = true;

        try {
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            isLoginValid = false;
        }

        try {
            checkPasswords(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            isPasswordValid = false;
        }
        finally {
            if (isLoginValid && isPasswordValid) {
                System.out.println("Проверка завершена.");
        }

        }

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


    // Метод проверки пароля.
    // Повторный пароль, вызов исключения по ошибке ввода пароля.

    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException {

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка! Пароли не одинаковые.");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Ошибка! Превышена длина логина.");
        }

        // Вызов исключения по ошибке ввода пароля.

        char[] charArray = password.toCharArray();
        for (char ch : charArray) {
            if (ch < '0' | ch > '9' & ch < 'A' |
                    ch > 'Z' & ch < 'a' & ch != '_' | ch > 'z') {
                throw new WrongPasswordException("Используются недопустимые для пароля символы.");
            }
        }

    }
}
