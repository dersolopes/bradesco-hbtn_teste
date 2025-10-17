import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;

// Classe de teste para validar o comportamento da classe Person
public class PersonTest {
    private Person person; // Instância de Person usada nos testes

    // Metodo executado antes de cada teste para inicializar a instância de Person
    @BeforeEach
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1); // Define a data de nascimento
        Date birthDate = cal.getTime();
        // Inicializa a pessoa com restrições que impedem ser MEI
        person = new Person("Paul", "McCartney", birthDate, true, true, true);
        person.setSalary(1200); // Define o salário mensal
    }

    // Testa se o metodo fullName retorna o nome completo corretamente
    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    // Testa se o cálculo do salário anual está correto
    @Test
    public void test_calculateYearlySalary() {
        assertEquals(14400, person.calculateYearlySalary(), 0.01);
    }

    // Testa se a pessoa está apta a ser MEI (deve retornar true)
    @Test
    public void person_is_MEI() {
        person = new Person("Paul", "McCartney", getBirthDate(1990), false, false, false);
        person.setSalary(1000);
        assertTrue(person.isMEI());
    }

    // Testa se a pessoa NÃO está apta a ser MEI (deve retornar false)
    @Test
    public void person_is_not_MEI() {
        person = new Person("Paul", "McCartney", getBirthDate(2005), false, false, false);
        person.setSalary(12000);
        assertFalse(person.isMEI());
    }

    // Metodo auxiliar para criar datas de nascimento
    private Date getBirthDate(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.JANUARY, 1);
        return cal.getTime();
    }
}