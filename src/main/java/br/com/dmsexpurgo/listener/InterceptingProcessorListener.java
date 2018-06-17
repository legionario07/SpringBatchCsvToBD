package br.com.dmsexpurgo.listener;

import java.io.File;
import java.util.List;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.DbConfig;
import br.com.dmsexpurgo.configuration.FileConfig;
import br.com.dmsexpurgo.databases.DataSourceConfiguration;
import br.com.dmsexpurgo.model.FileGeneratedContent;
import br.com.dmsexpurgo.readers.FilesReaderImpl;
import br.com.dmsexpurgo.utils.LoggerUtil;

@Component
public class InterceptingProcessorListener implements ItemProcessListener<List<File>, List<FileGeneratedContent>> {

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
	public void beforeProcess(List<File> item) {
		System.out.println("Iniciando processamento");
		
	}

	@Override
	public void afterProcess(List<File> item, List<FileGeneratedContent> result) {
		System.out.println("Termino do processamento");
		
	}

	@Override
	public void onProcessError(List<File> item, Exception e) {
		// TODO Auto-generated method stub
		
	}



}
