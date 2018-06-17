package br.com.dmsexpurgo.databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.model.FileGeneratedContent;

@Component
public class FileGeneratedContentItemPreparedStatementSetter {

	@Bean
	public ItemPreparedStatementSetter<FileGeneratedContent> getSetter() {

		return new ItemPreparedStatementSetter<FileGeneratedContent>() {

			@Override
			public void setValues(FileGeneratedContent item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.getInvoiceId());
				ps.setString(2, item.getIsUnlimitedServices());
			}

		};

	}

}
