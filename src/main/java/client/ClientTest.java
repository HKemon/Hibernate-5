package client;

import entities.Partner;
import entities.Person;
import entities.Phone;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
            Root<Person> personRoot = criteriaQuery.from(Person.class);
            personRoot.join("person");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        getAllEmployee(sessionFactory);
//        getEmployeeById(sessionFactory);
//        updateEmployeeSalaryById(sessionFactory);
//    }
//    public static void main(String[] args) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Employee employee = new Employee();
//            session.beginTransaction();
//            employee.setEmployeeName("Emon");
//            Address address = new Address();
//            address.setStreet("Test Street");
//            employee.setAddress(address);
//            session.save(employee);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        getEmployeeAndAddressByEmployeeId(sessionFactory);
//    }

//    public static void main(String[] args) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
////            List<Object[]> lists = session.createNativeQuery("Select employee_id,employee_name from employee_table")
////                    .addScalar("employee_id",IntegerType.INSTANCE)
////                    .addScalar("employee_name",StringType.INSTANCE)
////                    .list();
//            List<Employee> list = session.createNativeQuery("Select employee_id,employee_name,address_id from employee_table")
//                    .addEntity(Employee.class)
//                    .list();
//            for (Employee object : list) {
//                Integer id = object.getEmployeeId();
//                String name = object.getEmployeeName();
//                System.out.println(id);
//                System.out.println(name);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query<Employee> query = session.getNamedQuery("Employee.byId");
//            query.setParameter("empId", 1);
//            Employee employee = query.uniqueResult();
//            System.out.println(employee);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    private static void getEmployeeAndAddressByEmployeeId(SessionFactory s) {
//        try (Session session = s.openSession()) {
//            String HQL = "From Employee emp Left Join Fetch emp.address where emp.employeeId=:empId";
//            Query<Employee> query = session.createQuery(HQL, Employee.class);
//            query.setParameter("empId", 1);
//            Employee employee = query.uniqueResult();
//            System.out.println(employee);
//            Address address = employee.getAddress();
//            System.out.println(address);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static void updateEmployeeSalaryById(SessionFactory s) {
//        double newSalary = 50000.0;
//        int empId = 1;
//        try (Session session = s.openSession()) {
//            String HQL = "update Employee set salary=:newSalary where employeeId=:empId";
//            Query query = session.createQuery(HQL);
//            query.setParameter("newSalary", newSalary);
//            query.setParameter("empId", empId);
//            session.beginTransaction();
//            query.executeUpdate();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void getAllEmployee(SessionFactory s) {
//        try (Session session = s.openSession()) {
//            String HQL = "From Employee";
//            final Query<Employee> query = session.createQuery(HQL, Employee.class);
//            List<Employee> list = query.list();
//            list.forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void getEmployeeById(SessionFactory s) {
//        try (Session session = s.openSession()) {
//            String HQL = "From Employee where employeeId=:employeeId";
//            Query<Employee> query = session.createQuery(HQL, Employee.class);
//            query.setParameter("employeeId", 1);
//            Employee employee = query.uniqueResult();
//            System.out.println(employee);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}