/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hibernate.bugs;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.test.Bank;
import org.hibernate.test.BankAccount;
import org.hibernate.test.BankDepartment;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using its built-in unit test framework.
 * Although ORMStandaloneTestCase is perfectly acceptable as a reproducer, usage of this class is much preferred.
 * Since we nearly always include a regression test with bug fixes, providing your reproducer using this method
 * simplifies the process.
 *
 * What's even better?  Fork hibernate-orm itself, add your test case directly to a module's unit tests, then
 * submit it as a PR!
 */
public class ORMUnitTestCase extends BaseCoreFunctionalTestCase {

	@Override
	protected Class[] getAnnotatedClasses() {
		return new Class[] {
				BankAccount.class,
				Bank.class,
				BankDepartment.class
		};
	}

	@Override
	protected void configure(Configuration configuration) {
		super.configure( configuration );

		configuration.setProperty( AvailableSettings.SHOW_SQL, Boolean.TRUE.toString() );

		configuration.setProperty( AvailableSettings.ALLOW_ENHANCEMENT_AS_PROXY, Boolean.TRUE.toString() );
	}

	@Test
	public void hhh123Test() throws Exception {
		Session s = openSession();
		Transaction tx = s.beginTransaction();

		BankAccount account = s.find(BankAccount.class, 1L);

		s.createNativeQuery("SELECT 1").getResultList();

		Bank bank = account.getBank();
		System.out.println(Hibernate.isInitialized(bank));
		List<BankDepartment> deps = bank.getDepartments();
		System.out.println(deps.size());

		Assert.assertEquals(deps.size(), 3);

		tx.commit();
		s.close();
	}
}
