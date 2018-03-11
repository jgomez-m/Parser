package com.ef.config;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.StringUtils;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
    
	@Autowired
	private JobLauncher jobLauncher;
	/**
	 * Data Job.
	 */
	@Autowired
	private Job job;
	
	@Value("${duration}")
    private String duration;
	
	@Value("${threshold}")
    private String threshold;
	
	@Value("${startDate}")
    private String startDate;

    /**
	 * Initialization Method.
	 */
	@PostConstruct
	private void init() {
		try {
			long start = System.currentTimeMillis();
			LOGGER.info("<<<<<<<<<<<<<START>>>>>>>>>>>>>>: " + new Date(start));
			JobParameters jobParams = new JobParameters();
			JobExecution execution = this.jobLauncher.run(this.job, jobParams);
			LOGGER.info("<<<<<<<<<<<<<Exit Status>>>>>>>>>>>>>>: " + execution.getStatus());

			System.exit(0);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException ex) {
			LOGGER.error("Error", ex);
		}
	}

}
