package be.atc.warehousemgmt.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

@Configuration
@EnableJpaRepositories(value = "be.atc.warehousemgmt.model.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class DatabaseConfig {

    @Value("${jpa.connection.driver:com.mysql.jdbc.Driver}")
    private String driverClassName;
    @Value("${jpa.connection.url:jdbc:mysql://localhost:3306/warehousemgmtDB}")
    private String dataBaseUrl;
    @Value("${jpa.connection.username:root}")
    private String dataBaseUserName;
    @Value("${jpa.connection.password:}")
    private String dataBasePassword;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dataBaseUrl);
        dataSource.setUsername(dataBaseUserName);
        dataSource.setPassword(dataBasePassword); //si j'enlève cette ligne ça fonctionne...
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("be.atc.warehousemgmt.model.entity");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "none"); /* Set to create if you want to reinit the database or set to none */
        jpaProperties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        jpaProperties.put("hibernate.cache.use_query_cache", "true");
        jpaProperties.put("hibernate.cache.use_second_level_cache", "true");
        jpaProperties.put("hibernate.show_sql", "false");
        jpaProperties.put("hibernate.connection.characterEncoding", "utf8");
        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.EJB3NamingStrategy");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
