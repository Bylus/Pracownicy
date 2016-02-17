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
    private String bonus;
    private String startyear;
    private String company;
    private String position;

    public Worker(String name, String surname, String year, String month, String day, String salary, String bonus, String startyear, String company, String position) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.month = month;
        this.day = day;
        this.salary = salary;
        this.bonus = bonus;
        this.startyear = startyear;
        this.company = company;
        this.position = position;
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

    public String getBonus() {
        return bonus;
    }

    public String getStartyear() {
        return startyear;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

}
