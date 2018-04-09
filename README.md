Spring and Hibernate integration example with only Java code

Notes
===========

For dataSource I used Tomcat JDBC Connection Pooling(added dependency in pom.xml)

Configuration
=============
Spring supports us with bootstrapping the Hibernate SessionFactory.

All we have to do is to define some beans as well as a few parameters.

With Spring, we have two options for these configurations, a Java-based and an XML-based way.

In this example I used Java-based configuration.

For using Hibernate 5 with Spring, little has changed since Hibernate 4: 
we have to use LocalSessionFactoryBean from the package org.springframework.orm.hibernate5 instead of org.springframework.orm.hibernate4.

Like with Hibernate 4 before, we have to define beans for LocalSessionFactoryBean, DataSource, and PlatformTransactionManager,
as well as some Hibernate-specific properties.

See HibernateConfiguration.class for detail inforamtion how to configure hibernate with only Java code.
