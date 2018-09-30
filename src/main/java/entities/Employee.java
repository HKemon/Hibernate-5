package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class Employee extends Person {
    @Column(name = "salary")
    private double salary;

    @Column(name = "dept")
    private String dept;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}