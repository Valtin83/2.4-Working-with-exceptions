public class WrongPasswordException extends Exception{

    // Конструктор по умолчанию

    public WrongPasswordException(String message) {
        super(message);
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
