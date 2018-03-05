package com.ef.config;

import java.util.Arrays;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.ef.Loader;

/**
 * Provided class to configuration.
 *
 * @author Julian Gomez
 */
@Configuration
/*
 * read context files.
 */
@ImportResource({
    "classpath:applicationContext-db.xml",
    "file:config/applicationContext-batch.xml"
})
public class Bootstrap{

    /**
     * Logger.
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(Bootstrap.class);

    
}
