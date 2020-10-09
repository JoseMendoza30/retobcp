package com.bcp.app.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class TransactionContextConfig {

    @Bean(name = "hibernateTransactionManager")
    public PlatformTransactionManager bdmunicTransactionManager(@Qualifier("entityManagerFactoryBean") EntityManagerFactory emf) {
        JpaTransactionManager txm = new JpaTransactionManager();
        txm.setEntityManagerFactory(emf);

        return txm;
    }

}
