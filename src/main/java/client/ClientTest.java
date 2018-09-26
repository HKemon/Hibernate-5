package client;

import org.hibernate.Session;
import util.HibernateUtil;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "select version()";
            String result = (String) session.createNativeQuery(sql).getSingleResult();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
