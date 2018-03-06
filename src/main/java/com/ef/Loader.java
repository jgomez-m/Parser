package com.ef;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Loader implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Loader.class);
	/**
	 * Job launcher.
	 */
	@Autowired
	private JobLauncher jobLauncher;
	/**
	 * Data Job.
	 */
	@Autowired
	private Job job;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Loader.class, args);
		
	}

	public void run(ApplicationArguments args) throws Exception {

	}

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

			long end = System.currentTimeMillis();
			LOGGER.info("<<<<<<<<<<<<<END>>>>>>>>>>>>>>: " + new Date(end));

			LOGGER.info("<<<<<<<<<<<<<TIME IN MILLIS:>>>>>>>>>>>>>>" + (end - start));

			System.exit(0);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException ex) {
			LOGGER.error("Error", ex);
		}
	}

}
