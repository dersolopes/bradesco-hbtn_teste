import java.util.Date;
import java.util.Calendar;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public float calculateYearlySalary() {
        return salary * 12; // Calcula o salário anual
    }

    public int getAge() {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    // Valida se é um MEI (Microempreendedor Individual)
    public boolean isMEI() {
            if (calculateYearlySalary() >= 130000) { return false; } // Limite anual
            if (getAge() <= 18) { return false; } // Idade mínima
            if (anotherCompanyOwner) { return false; } // Não pode ser dono de outra empresa
            if (pensioner) { return false; } // Não pode ser pensionista
            if (publicServer) { return false; } // Não pode ser servidor público

            return true; // Atende a todos os critérios para ser MEI
        }

    // Getters e setters
    public String fullName() { return name + " " + surname; } // Retorna o nome completo
    public float getSalary() { return salary; } // Retorna o salário
    public void setSalary(float salary) { this.salary = salary; } // Define o salário
}
