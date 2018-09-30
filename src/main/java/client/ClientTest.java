package client;

import entities.Employee;
import entities.Person;
import org.hibernate.Session;
import util.HibernateUtil;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Person person = new Person();
            person.setName("person");
            person.setGender("Unknown");

            Employee employee = new Employee();
            employee.setName("employee");
            employee.setGender("unknown");
            employee.setDept("test dept");
            employee.setSalary(10000.0);

            session.beginTransaction();
            session.save(person);
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
