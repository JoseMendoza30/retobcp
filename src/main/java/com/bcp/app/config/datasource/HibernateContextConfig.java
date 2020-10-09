package com.bcp.app.config.datasource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.bcp.app.repository", "com.bcp.app.service"},
        entityManagerFactoryRef = "entityManagerFactoryBean"
        ,transactionManagerRef = "hibernateTransactionManager"
)
public class HibernateContextConfig {

    @Bean(name = "entityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(packagesToScan());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        em.setJpaProperties(hibernateProperties());

        return em;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        
        return hibernateProperties;
    }

    private String[] packagesToScan() {
        return new String[]{
                "com.bcp.app.entity"
        };
    }

}
