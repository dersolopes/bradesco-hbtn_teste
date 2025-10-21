import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    private Person person;

    // Inicializar o objeto Person antes de todos os testes serem executados
    @BeforeAll
    public void setup() {
        person = new Person();
    }

    // valida se o metodo checkUser() aceita nomes de usuario validos
    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    void check_user_valid(String username) {
        assertTrue(person.checkUser(username)); // Verifica se o metodo checkUser retorna true para nomes de usuario validos
    }

    // valida se o metodo checkUser() rejeita nomes de usuario invalidos
    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    void check_user_not_valid(String username) {
        assertFalse(person.checkUser(username));
    }

    // valida se o metodo checkPassword() rejeita senhas sem letras
    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));// senha sem letra maiuscula e/ou caractere especial
    }

    // valida se o metodo checkPassword() rejeita senhas sem numeros
    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));// senha sem numero
    }

    // valida se o metodo checkPassword() rejeita senhas com menos de 8 caracteres
    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));// senha com menos de 8 caracteres
    }

    // valida se o metodo checkPassword() aceita senhas validas
    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));// senha valida
    }
}
