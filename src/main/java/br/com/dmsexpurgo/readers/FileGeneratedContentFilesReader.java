package br.com.dmsexpurgo.readers;

import java.io.File;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FileGeneratedContentFilesReader{

	
	@Autowired
	FilesReaderImpl filesItemImpl;

	@Bean
    @StepScope
    public ItemReader<File> getFileReader(){
         ItemReader<File> itemReader = new ListItemReader<File>(filesItemImpl.getFilesForDelete());

          return itemReader;
    }
	
}
