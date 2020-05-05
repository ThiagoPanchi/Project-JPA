package br.sc.senai.dao;

import br.sc.senai.model.Pessoa;
import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDaoTest {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Users-db");

        entityManager = factory.createEntityManager();

        insert();
        //update();
        //delete();
    }
    public static void insert() {
        entityManager.getTransaction().begin();

        Pessoa newPessoa = new Pessoa();
        newPessoa.setName("Thiago");
        newPessoa.setLastname("Panchiniak");
        newPessoa.setCpf(2890);

        entityManager.persist(newPessoa);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public static void update() {
        entityManager.getTransaction().begin();
        Pessoa updatePessoa = entityManager.find(Pessoa.class, 1);

        //System.out.println(updateUser.getFullname());

        updatePessoa.setName("Teste Dois da Silva");

        //entityManager.merge(updateUser);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public static void delete() {
        entityManager.getTransaction().begin();
        Pessoa removePessoa = entityManager.find(Pessoa.class, 1);
        entityManager.remove(removePessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
