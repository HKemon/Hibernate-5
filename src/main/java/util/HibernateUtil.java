package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null){
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            if (standardServiceRegistry != null){
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

//import org.hibernate.cfg.Environment;
//
//        import java.util.HashMap;
//        import java.util.Map;

//    static {
//        // Create StandardServiceRegistryBuilder
//        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//
//        Map<String,String> databaseSettings = new HashMap<>();
//        databaseSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
//        databaseSettings.put(Environment.USER, "root");
//        databaseSettings.put(Environment.PASS, "root");
//        databaseSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//        databaseSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//
//        registryBuilder.applySettings(databaseSettings);
//        standardServiceRegistry = registryBuilder.build();
//        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
//        Metadata metadata = metadataSources.getMetadataBuilder().build();
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
//    }