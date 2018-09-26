package client;

import entities.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Date;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = getEmployee();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeName("Emon");
        employee.setEmail("emon@gmail.com");
        employee.setDob(new Date());
        employee.setSalary(2000.0);
        return employee;
    }
}
