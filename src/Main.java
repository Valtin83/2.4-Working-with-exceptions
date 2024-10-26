public class Main {

    public static void main(String[] args) {

        String login = "java_skнpro_go"; // Логин
        String password = "D_1hWikjjP_9"; // Пароль
        String confirmPassword = "D_1hWikjjP_9"; // Повтор пароля

        boolean isLoginValid = true;
        boolean isPasswordValid = true;

        try {
            WrongLoginException.checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            isLoginValid = false;
        }

        try {
            WrongPasswordException.checkPasswords(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            isPasswordValid = false;
        }
        finally {
            if (isLoginValid && isPasswordValid) {
                System.out.println("Проверка завершена.");
            } else {
                System.out.println("Повторите ввод.");
            }

        }
    }
}

