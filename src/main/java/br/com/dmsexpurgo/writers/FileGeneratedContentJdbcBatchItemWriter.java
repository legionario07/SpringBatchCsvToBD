package br.com.dmsexpurgo.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.DbConfig;
import br.com.dmsexpurgo.databases.DataSourceConfiguration;
import br.com.dmsexpurgo.databases.FileGeneratedContentItemPreparedStatementSetter;
import br.com.dmsexpurgo.model.FileGeneratedContent;

@Component
public class FileGeneratedContentJdbcBatchItemWriter implements ItemWriter<FileGeneratedContent> {

	@Autowired
	DataSourceConfiguration dataSource;

	@Autowired
	FileGeneratedContentItemPreparedStatementSetter itemPreparedStatementSetter;

	@Autowired
	DbConfig dbConfig;

	@Override
	public void write(List<? extends FileGeneratedContent> items) throws Exception {

		JdbcBatchItemWriter<FileGeneratedContent> writer = new JdbcBatchItemWriter<FileGeneratedContent>();
		writer.setDataSource(dataSource.getDataSource());
		writer.setItemPreparedStatementSetter(itemPreparedStatementSetter.getSetter());
		writer.setSql(dbConfig.getSqlDelete());
		try {
			writer.write(items);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("EmptyResultDataAccessException");
		}

		
	}


}
