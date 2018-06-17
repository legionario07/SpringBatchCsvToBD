package br.com.dmsexpurgo.processor;

import java.io.File;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.FileConfig;
import br.com.dmsexpurgo.model.FileGeneratedContent;

@Component
public class FilesProcessImpl {

	@Autowired
	FileConfig fileConfig;

	public FileGeneratedContent getDataForFile(File file) {

		FileGeneratedContent fileGeneratedContent = new FileGeneratedContent();
		try {
			String[] nameSplits = file.getName().split(fileConfig.getRegex());

			fileGeneratedContent.setInvoiceId(nameSplits[fileConfig.getSplitIndexInvoiceId()]);

			String[] isUnlimitedServices = nameSplits[fileConfig.getSplitIndexIsUnlimitedService()]
					.split(Pattern.quote("."));
			fileGeneratedContent.setIsUnlimitedServices(isUnlimitedServices[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Não tem formato de Fatura");
		}

		return fileGeneratedContent;
	}

}
