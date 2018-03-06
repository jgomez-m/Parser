package com.ef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

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
        SpringApplication.run(Parser.class, args);
    }
    
}
