
package pracownicy;

import javax.swing.JTextField;

/**
 *
 * @author Maciek
 */
public class Worker {

    private String name;
    private String surname;
    private String year;
    private String month;
    private String day;
    private String salary;

    public Worker(String name, String surname, String year, String month, String day, String salary) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.month = month;
        this.day = day;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getSalary() {
        return salary;
    }

}
