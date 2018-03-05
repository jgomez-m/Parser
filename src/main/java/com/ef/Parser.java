package com.ef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * Main Class.
 *
 * @author Julian Gomez
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Parser {
    
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Parser.class);
    
    /**
     * Main Method.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Parser.class, args);
        String startDate = ctx.getEnvironment().getProperty("startDate");
        LOGGER.info(startDate);
    }
    
}
