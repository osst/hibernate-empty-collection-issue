package org.hibernate.bugs;

import org.hibernate.test.Bank;
import org.hibernate.test.BankAccount;
import org.hibernate.test.BankDepartment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		BankAccount account = entityManager.find(BankAccount.class, 1L);

		entityManager.createNativeQuery("SELECT 1").getResultList();

		Bank bank = account.getBank();
		List<BankDepartment> deps = bank.getDepartments();

		Assert.assertEquals(deps.size(), 3);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
