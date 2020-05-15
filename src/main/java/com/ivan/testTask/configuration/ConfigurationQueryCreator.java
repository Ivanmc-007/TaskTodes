package com.ivan.testTask.configuration;

import com.ivan.testTask.myCriteria.QueryCreator;
import com.ivan.testTask.myCriteria.QueryCreatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationQueryCreator {

    @Bean
    public QueryCreator queryCreator() {
        return new QueryCreatorImpl();
    }

}
