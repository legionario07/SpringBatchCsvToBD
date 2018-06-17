package br.com.dmsexpurgo.listener;

import java.io.File;
import java.util.List;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.DbConfig;
import br.com.dmsexpurgo.configuration.FileConfig;
import br.com.dmsexpurgo.databases.DataSourceConfiguration;
import br.com.dmsexpurgo.readers.FilesReaderImpl;
import br.com.dmsexpurgo.utils.LoggerUtil;

@Component
public class InterceptingReaderListener implements ItemReadListener<List<File>> {

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
	public void beforeRead() {
		System.out.println("BeforeRead");
		
	}

	@Override
	public void afterRead(List<File> item) {
		System.out.println("After Read");
		System.out.println("Tamanho: "+item.size());
		
	}

	@Override
	public void onReadError(Exception ex) {
		// TODO Auto-generated method stub
		
	}


}
