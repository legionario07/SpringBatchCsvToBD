package br.com.dmsexpurgo.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.DbConfig;
import br.com.dmsexpurgo.configuration.FileConfig;
import br.com.dmsexpurgo.databases.DataSourceConfiguration;
import br.com.dmsexpurgo.readers.FilesReaderImpl;
import br.com.dmsexpurgo.utils.LoggerUtil;

@Component
public class InterceptingJobExecutionListener implements JobExecutionListener {

	@Autowired
	DataSourceConfiguration d;

	@Autowired
	FileConfig fileConfig;

	@Autowired
	FilesReaderImpl fileProcess;

	@Autowired
	DbConfig dc;

	@Autowired
	LoggerUtil loggerUtil;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		//
		// Can Log || do some business code
		//
		System.out.println("Before JobExecutionListener");
		System.out.println("Inicio do Expurgo: " + loggerUtil.getDateFormatter(new Date()));
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		//
		// Can Log || do some Business code
		//
		System.out.println("After JobExecutionListener");
		System.out.println("Fim do Expurgo: " + loggerUtil.getDateFormatter(new Date()));

	}

}
