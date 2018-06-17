package br.com.dmsexpurgo.processor;

import java.io.File;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.model.FileGeneratedContent;
import br.com.dmsexpurgo.utils.LoggerUtil;

@Component
public class FileListProcessor implements ItemProcessor<File, FileGeneratedContent> {

	@Autowired
	FilesProcessImpl filesProcessImpl;
	
	@Autowired
	LoggerUtil loggerUtil;

	@Override
	public FileGeneratedContent process(File files) throws Exception {
		System.out.println("Iniciando Processamento: " + loggerUtil.getDateFormatter(new Date()));
		
		return filesProcessImpl.getDataForFile(files);
	}
	
}
