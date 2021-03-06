/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.hibernate.ogm.test.utils;

import junit.framework.Assert;

import org.hibernate.ogm.test.simpleentity.Hypothesis;
import org.junit.Test;

/**
 * Verifies that SkipByGridDialect is applied by the
 *
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2012 Red Hat Inc.
 */
public class SkipByGridDialectSelfTest extends OgmTestCase {

	@Test
	@SkipByGridDialect({
		GridDialectType.HASHMAP, GridDialectType.INFINISPAN, GridDialectType.MONGODB, GridDialectType.EHCACHE, GridDialectType.NEO4J
	})
	public void testWhichAlwaysFails() {
		Assert.fail( "This should never be executed" );
	}

	@Test
	public void testCorrect() {
		// all fine
	}

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class<?>[] { Hypothesis.class };
	}

}
