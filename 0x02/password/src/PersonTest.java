import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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

    // valida a o metodo checkUser()e deve passar no teste para os sequintes valores: “Paul#McCartney”, “Neil@Arms”
    @Test
    public void does_not_have_letters(){
        assertFalse(person.checkUser("Paul#McCartney"));// usuario com caractere especial
        assertFalse(person.checkUser("Neil@Arms"));// usuario com caractere especial
    }

    // valida a o metodo checkUser()e deve passar no teste para os sequintes valores: “Paul#McCartney”, “Neil@Arms”
    @Test
    public void check_user_not_valid(){

        assertFalse(person.checkPassword("123456789"));// senha sem letra maiúscula e caractere especial
        assertFalse(person.checkPassword("#$%1234"));// senha sem letra maiúscula
    }

    // valida a o metodo checkPassword() usando senhas sem numeros
    @Test
    public void does_not_have_numbers(){
        assertFalse(person.checkPassword("Abcabcdefgh@"));// senha sem número
        assertFalse(person.checkPassword("#hbtn@%tc"));// senha sem número
    }

    // valida a o metodo checkPassword() usando senhas com menos de 8 caracteres
    @Test
    public void does_not_have_eight_chars(){
        assertFalse(person.checkPassword("Abc@123"));// senha com menos de 8 caracteres
        assertFalse(person.checkPassword("12$@hbt"));// senha com menos de 8 caracteres
    }
    // valida a o metodo checkPassword com senhas válidas
    @Test
    public void check_password_valid(){
        assertTrue(person.checkPassword("abC123456$"));// senha válida
        assertTrue(person.checkPassword("Hbtn@1234"));// senha válida
        assertTrue(person.checkPassword("Betty@1#2"));// senha válida
        assertTrue(person.checkPassword("Hbtn@123"));// senha válida
    }

//    // MEUS TESTES ABAIXO
//    @Test
//    public void testar_usuario_valido() {
//        assertTrue(person.checkUser("usuariocommaisde8caracteres"));// usuario com mais de 8 caracteres e sem caractere especial
//    }
//
//    @Test
//    public void testar_menos_de_8_caracteres() {
//        assertFalse(person.checkUser("user1"));// usuario com menos de 8 caracteres
//    }
//
//    @Test
//    public void testar_usuario_com_caractere_especial() {
//        assertFalse(person.checkUser("user@name"));// usuario com caractere especial
//
//    }
//
//    @Test
//    public void testar_senha_valida() {
//        assertTrue(person.checkPassword("Senh@Valida1"));
//
//    }
//    @Test
//    public void testar_senha_invalida() {
//        // senha com menos de 8 caracteres
//        assertFalse(person.checkPassword("S@1a"));
//        // senha sem letra maiúscula
//        assertFalse(person.checkPassword("senha@valida1"));
//        // senha sem número
//        assertFalse(person.checkPassword("Senha@Valida"));
//        // senha sem caractere especial
//        assertFalse(person.checkPassword("SenhaValida1"));
//    }
//
}

