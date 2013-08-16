/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
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
package org.hibernate.ogm.options.navigation.impl;

import java.lang.annotation.ElementType;

import org.hibernate.ogm.options.navigation.context.EntityContext;
import org.hibernate.ogm.options.navigation.context.GlobalContext;
import org.hibernate.ogm.options.navigation.context.PropertyContext;
import org.hibernate.ogm.options.spi.Option;
import org.hibernate.ogm.options.spi.NoSqlMapping.NoSqlPropertyContext;

/**
 * Container the common parts of different implementation of {@link PropertyContext}
 *
 * @author Davide D'Alto <davide@hibernate.org>
 */
public abstract class NoSqlPropertyContextImpl<G extends GlobalContext<G, E, P>, E extends EntityContext<G, E, P>, P extends PropertyContext<G, E, P>>
		implements NoSqlPropertyContext<G, E, P> {

	private final MappingContext context;
	private final E entity;
	private final String propertyName;
	private final Class<?> type;

	public NoSqlPropertyContextImpl(MappingContext context, E entity, Class<?> type, String propertyName) {
		this.entity = entity;
		this.type = type;
		this.propertyName = propertyName;
		this.context = context;
	}

	public E entity(Class<?> type) {
		return this.entity.entity( type );
	}

	public P property(String propertyName, ElementType target) {
		return this.entity.property( propertyName, target );
	}

	protected final void addOption(Option<?, ?> option) {
		context.addPropertyOption( type, propertyName, option );
	}

}