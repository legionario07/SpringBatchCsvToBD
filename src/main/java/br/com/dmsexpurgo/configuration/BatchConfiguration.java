package br.com.dmsexpurgo.configuration;

import java.io.File;
import java.util.Calendar;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dmsexpurgo.listener.InterceptingJobExecutionListener;
import br.com.dmsexpurgo.listener.InterceptingReaderListener;
import br.com.dmsexpurgo.model.FileGeneratedContent;
import br.com.dmsexpurgo.processor.FileListProcessor;
import br.com.dmsexpurgo.readers.FileGeneratedContentFilesReader;
import br.com.dmsexpurgo.writers.FileGeneratedContentJdbcBatchItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	InterceptingJobExecutionListener interceptingJobExecution;
	
	@Autowired
	FileGeneratedContentFilesReader fileGeneratedContentFlatFileReader;
	
	@Autowired
	FileListProcessor fileListProcessor;
	
	@Autowired
	FileGeneratedContentJdbcBatchItemWriter filesWriter;
	
	@Autowired
	InterceptingReaderListener interceptingReader;
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("reader_step").<File,FileGeneratedContent>chunk(1)
				.reader(fileGeneratedContentFlatFileReader.getFileReader())
				.processor(fileListProcessor)
				.listener(interceptingReader)
				.writer(filesWriter)
				.build();
	}
	
	@Bean
	public Job expurgoFilesJob() {
		RunIdIncrementer run = new RunIdIncrementer();
		run.setKey(String.valueOf(Calendar.getInstance().getTimeInMillis()));
		return jobBuilderFactory.get("expurgoFileJob")
				.incrementer(run)
				.flow(step1())
				.end()
				.listener(interceptingJobExecution)
				.build();
				
	}
	
	
	
}

