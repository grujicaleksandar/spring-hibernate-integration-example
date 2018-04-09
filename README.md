Spring and Hibernate integration example with only Java code

Configuration
=============
Spring supports us with bootstrapping the Hibernate SessionFactory.

All we have to do is to define some beans as well as a few parameters.

With Spring, we have two options for these configurations, a Java-based and an XML-based way.

In this example I used Java-based configuration.

For using Hibernate 5 with Spring, little has changed since Hibernate 4: 
we have to use LocalSessionFactoryBean from the package org.springframework.orm.hibernate5 instead of org.springframework.orm.hibernate4.

**Like with Hibernate 4 before, we have to define beans for LocalSessionFactoryBean, DataSource, and PlatformTransactionManager,
as well as some Hibernate-specific properties.**

See HibernateConfiguration.class for detail information how to configure hibernate with only Java code.
You can use App.class to test the program


Notes
===========

For dataSource I used Tomcat JDBC Connection Pooling(added dependency in pom.xml)
If you want,you can use c3p0 connection pool.
Just add dependency in pom.xml
```
 <dependency>
    	<groupId>org.hibernate</groupId>
    	<artifactId>hibernate-c3p0</artifactId>
    	<version>5.2.6.Final</version>
    </dependency>
```
And HibernateConfiguration.class will look like this:

```
@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	  @Bean
    	public ComboPooledDataSource dataSource() {
        // a named datasource is best practice for later jmx monitoring
        ComboPooledDataSource dataSource = new ComboPooledDataSource("jupiter");
 
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException pve){
            System.out.println("Cannot load datasource driver (" + "com.mysql.jdbc.Driver" +") : " + pve.getMessage());
            return null;
        }
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_hibernate_database");
        dataSource.setUser("username");
        dataSource.setPassword("password");
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxIdleTime(600);
 
        return dataSource;
    }
	 @Bean
	 public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	        sessionFactoryBean.setDataSource(dataSource());
	        sessionFactoryBean.setPackagesToScan("spring_hibernate_integration.model");
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        hibernateProperties.put("hibernate.show_sql", true);
	        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	        sessionFactoryBean.setHibernateProperties(hibernateProperties);
	 
	        return sessionFactoryBean;
	    }
	 @Bean
	  public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager transactionManager =
	                new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	
}


```


