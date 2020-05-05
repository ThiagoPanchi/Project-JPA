package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyDaoTest {
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

        Company newCompany = new Company();
        newCompany.setName("Java Inc.");



        entityManager.persist(newCompany);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
