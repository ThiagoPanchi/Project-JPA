package br.sc.senai.dao;

import br.sc.senai.model.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Users-db");

        entityManager = factory.createEntityManager();

        //insert();
        update();
    }

    public static void insert() {
        entityManager.getTransaction().begin();

        User newUser = new User();
        newUser.setEmail("ateste@gmail.com");
        newUser.setFullname("teste testinho");
        newUser.setPassword("senhasecreta");

        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public static void update() {
        entityManager.getTransaction().begin();
        User updateUser = entityManager.find(User.class, 1);

        //System.out.println(updateUser.getFullname());

        updateUser.setFullname("Teste Dois da Silva");
        updateUser.setEmail("testedois@gmail.com");
        //entityManager.merge(updateUser);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public static void delete() {
        entityManager.getTransaction().begin();
        User removeUser = entityManager.find(User.class, 1);
        entityManager.remove(removeUser);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
