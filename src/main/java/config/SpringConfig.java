package config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import rosterBuilder.helpers.WargameSystemsInitializer;
import rosterBuilder.pojos.WargamingSystem;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"common", "config", "diceRollSimulator", "rosterBuilder", "scenarioGenerator", "scoreCalculator", "tournamentHandler", "security"})
public class SpringConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        System.out.println("inside logging filter");
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(false);
        return loggingFilter;
    }

    @Bean
    public WargamingSystem wargamingSystem(){
        List<WargamingSystem> wargames = new WargameSystemsInitializer().initialize();
        return wargames.get(0);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        }
        catch(PropertyVetoException e){
            throw new RuntimeException(e);
        }

        dataSource.setJdbcUrl("jdbc:mysql://localhost/wargaming_assistant?allowPublicKeyRetrieval=true&useSSL=false");
        dataSource.setUser("hibernate");
        dataSource.setPassword("hibernate");

//        System.out.println("hibernate.connection.url: " + env.getProperty("hibernate.connection.url"));
//        System.out.println("hibernate.connection.username: " + env.getProperty("hibernate.connection.username"));
//        System.out.println("hibernate.connection.password: " + env.getProperty("hibernate.connection.password"));

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxIdleTime(1800);
        dataSource.setMaxStatements(5);

//        System.out.println("hibernate.hibernate.init costam: " + env.getProperty("hibernate.hibernate.min_size"));
//        System.out.println("hibernate.hibernate.min_size: " + env.getProperty("hibernate.hibernate.min_size"));
//        System.out.println("hibernate.hibernate.max_size: " + env.getProperty("hibernate.hibernate.max_size"));
//        System.out.println("hibernate.hibernate.timeout: " + env.getProperty("hibernate.hibernate.timeout"));
//        System.out.println("hibernate.hibernate.max_statements: " + env.getProperty("hibernate.hibernate.max_statements"));

        return dataSource;
    }

    public int getIntProperty(String string){
        String property = env.getProperty(string);

        return Integer.parseInt(property);
    }

    private Properties getHibernateProperties(){
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.current_session_context_class", "thread");

        return properties;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(this.dataSource());
        sessionFactory.setPackagesToScan("common", "config", "diceRollSimulator", "rosterBuilder", "scenarioGenerator", "scoreCalculator", "tournamentHandler", "security");
        sessionFactory.setHibernateProperties(this.getHibernateProperties());

        //sessionFactory.setAnnotatedClasses(UserEntity.class, RoleEntity.class, CustomerEntity.class);

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
