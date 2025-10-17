public class Pessoa {

    //Esse metodo verifica se um email possui um formato valido
    //Deve ter '@' e possuir no máximo 50 caracteres.
    static boolean emailValid (String email){
        if (email !=null && email.contains("@") && email.length() <= 50){
            return true;
        }
        return false;
    }
}