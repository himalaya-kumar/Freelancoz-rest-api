package com.freelancoz.project;

import com.freelancoz.model.ContactInformation;
import com.freelancoz.model.Client;
import com.freelancoz.model.Lancer;
import com.freelancoz.model.Project;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HibernateUtil {

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        if(Objects.isNull(sessionFactory)){
            try{
                standardServiceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(dbSettingPostGresDB()).build();
                sessionFactory = new MetadataSources(standardServiceRegistry)
                        .addAnnotatedClass(ContactInformation.class)
                        .addAnnotatedClass(Client.class)
                        .addAnnotatedClass(Project.class)
                        .addAnnotatedClass(Lancer.class)
                        .getMetadataBuilder().build()
                        .getSessionFactoryBuilder().build();

            }catch (Exception e){
                e.printStackTrace();
                if(!Objects.isNull(standardServiceRegistry)){
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }
            }
        }
    }

    private static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    /**
     * Hard Coded POSTGRES DB Setting
     * @return Map<String,String>
     */
    private static Map<String,String> dbSettingPostGresDB(){
        Map<String,String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL,"jdbc:postgresql://127.0.0.1:5432/Lancoz_REST");
        dbSettings.put(Environment.USER,"postgres");
        dbSettings.put(Environment.PASS,"1234");
        dbSettings.put(Environment.DRIVER,"org.postgresql.Driver");
        dbSettings.put(Environment.SHOW_SQL,"true");
        dbSettings.put(Environment.FORMAT_SQL,"true");
        dbSettings.put(Environment.POOL_SIZE,"4");
        dbSettings.put(Environment.USE_SQL_COMMENTS,"true");
        dbSettings.put(Environment.HBM2DDL_AUTO,"create");
        return dbSettings;
    }

    public static void main(String[] args) {
        ContactInformation contactInformation = new ContactInformation("NYC","PASSADENA","12345");
        Client client = new Client("Hi", contactInformation);
        Project projectOne = new Project("ProjectOne");
        Project projectTwo = new Project("ProjectTwo");
//        client.setProjectSet(Stream.of(projectOne,projectTwo).collect(Collectors.toSet()));
        Lancer lancer = new Lancer("one", contactInformation);
        Lancer lancer1 = new Lancer("two", contactInformation);
        projectOne.setClient(client);
        projectTwo.setClient(client);

        projectOne.setLancerList(Arrays.asList(lancer,lancer1));
        projectTwo.setLancerList(Arrays.asList(lancer,lancer1));

        lancer.setProjectList(Arrays.asList(projectOne,projectTwo));
        lancer1.setProjectList(Arrays.asList(projectOne,projectTwo));

        try(Session session = getSessionFactory().openSession()){

            session.beginTransaction();
            session.persist(client);
            session.persist(projectOne);
            session.persist(projectTwo);
            session.persist(lancer);
            session.persist(lancer1);
            session.getTransaction().commit();

            if(!Objects.isNull(session))
            session.close();

        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if(sessionFactory != null){
            sessionFactory.close();
            }
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }
}