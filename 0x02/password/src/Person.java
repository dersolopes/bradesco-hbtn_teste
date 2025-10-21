
public class Person {

    // Este metodo verifica se o usuario tem no mínimo 8 caracteres e nao possui caractere especial
    public static boolean checkUser(String user) {
        if (user.length() < 8) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            char c = user.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
    // Este metodo verifica se a senha tem no mínimo 8 caracteres, possui pelo menos uma letra maiúscula, um número e um caractere especial
    public static boolean checkPassword(String password) {

        // verifica se a senha tem pelo menos 8 caracteres
        if (password.length() < 8) {
            return false;
        }

        // variáveis para rastrear os critérios
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // percorre cada caractere da senha
        for (int i = 0; i < password.length(); i++) {

            // pega o caractere na posição i e armazena na variável c
            char c = password.charAt(i);

            // verifica se é letra maiúscula
            if (Character.isUpperCase(c)) {
                hasUpper = true;

                // verifica se é número
            }   else if (Character.isDigit(c)) {
                hasDigit = true;

                // verifica se é caractere especial
            }   else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        // retorna true se todos os critérios forem atendidos
        if (hasUpper && hasDigit && hasSpecial) {
            return true;
        }
        return false;
    }
}
