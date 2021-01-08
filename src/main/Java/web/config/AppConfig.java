package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


/*Аннотация @EnableTransactionManagement указывает Спринг, что классы с
аннотацией @Transactional, должны быть обернуты аспектом транзакций. */
@Configuration
@ComponentScan(value = "web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class AppConfig {

    Environment env;


    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    // аналог Connection connection = DriverManager.getConnection(url, username, password)
    // DriverManagerDataSource, не рекомендуется, т.к. это только замена нормального пула соединений и в целом подходит только для тестов
    // Для нормального приложения предпочтительнее использовать какую-нибудь DBCP библиотеку. 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.pass"));
        return dataSource;
    }

    // этот метод нужен чтобы представить свойства Hibernate в виде объекта Properties
    public Properties getAdditionalProperties() {
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        return properties;
    }

     /*для создания сессий, с помощью которых осуществляются операции с объектами-сущностями. 
     Здесь мы устанавливаем источник данных, свойства Hibernate и в каком пакете нужно искать классы-сущности.*/
    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        emf.setDataSource(getDataSource());
        emf.setJpaVendorAdapter(vendor);
        emf.setPackagesToScan(new String[] {"web"}); // ТУТ проверить
        emf.setJpaProperties(getAdditionalProperties());
        return emf;
    }

    // для настройки менеджера транзакций.
    @Bean
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return transactionManager;
    }

//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }






}
