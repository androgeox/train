package com.georgiy.denga.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value= {"classpath:application.properties"})
@EnableJpaRepositories(basePackages = {"com.georgiy.denga.repository"})
//@EnableWebSecurity
public class DataConfig {

//  private Environment environment;
//
//  @Autowired
//  public DataConfig(Environment environment) {
//    this.environment = environment;
//  }
//
//  @Bean
//  public DataSource dataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(environment.getRequiredProperty("db_driver"));
//    dataSource.setUrl(environment.getRequiredProperty("db_url"));
//    dataSource.setUsername(environment.getRequiredProperty("db_user"));
//    dataSource.setPassword(environment.getRequiredProperty("db_password"));
//    dataSource.setConnectionProperties(connectionProperties());
//    return dataSource;
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
//    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
//    emfb.setDataSource(dataSource);
//    emfb.setPackagesToScan(environment.getProperty("com.georgiy.denga"));
//    emfb.setJpaVendorAdapter(jpaVendorAdapter());
//    emfb.setJpaPropertyMap(jpaPropertiesMap());
//    return emfb;
//  }
//
//  @Bean
//  public JpaVendorAdapter jpaVendorAdapter() {
//    return new HibernateJpaVendorAdapter();
//  }
//
//
//  private Properties connectionProperties() {
//    Properties properties = new Properties();
//    properties.put("connection.useUnicode", environment.getProperty("connection.useUnicode"));
//    properties.put("connection.characterEncoding", environment.getProperty("connection.characterEncoding"));
//    return properties;
//  }
//
//  private Map<String, String> jpaPropertiesMap() {
//    Map<String, String> properties = new HashMap<>();
//    properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//    properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2dll"));
//    properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
////    properties.put("hibernate.jdbc.batch_size", "100");
////    properties.put("hibernate.order_inserts", "true");
////    properties.put("hibernate.order_updates", "true");
//    properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
//    properties.put("hibernate.default_schema", environment.getProperty("hibernate.default_schema"));
//    return properties;
//  }
//
//  @Bean
//  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(emf);
//    return transactionManager;
//  }
//}
  private final Environment environment;

  @Autowired
  public DataConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(new String[]{"com.georgiy.denga"});
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("db_driver"));
    dataSource.setUrl(environment.getRequiredProperty("db_url"));
    dataSource.setUsername(environment.getRequiredProperty("db_user"));
    dataSource.setPassword(environment.getRequiredProperty("db_password"));
    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
    properties.put("hibernate.default_schema", environment.getRequiredProperty("hibernate.default_schema"));
    return properties;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
    entityManager.setDataSource(dataSource());
    entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManager.setJpaProperties(hibernateProperties());
    entityManager.setPackagesToScan("com.georgiy.denga");
    return entityManager;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory s) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(s);
//        return txManager;
//    }
}

