package br.com.dmsexpurgo.readers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.FileConfig;

@Component
public class FilesReaderImpl {

	@Autowired
	FileConfig fileConfig;

	private List<File> filesOld = new ArrayList<File>();

	private SimpleDateFormat sdf;
	private Calendar calHoje = Calendar.getInstance();
	private Integer numberFilesDeleted = 0;
	private Integer numberFilesNotDeleted = 0;

	public List<File> getFilesForDelete() {

		sdf = new SimpleDateFormat(fileConfig.getPattern());
		System.out.println("Days para Expurgo: " + fileConfig.getDaysForDelete());
		System.out.println("Caminho: " + fileConfig.getPathFile());

		File file = new File(fileConfig.getPathFile());
		try {
			for (File f : file.listFiles()) {
				verificationCreateDate(f, filesOld);
			}

			System.out.println("Total de Files Excluidos: "+numberFilesDeleted);
			System.out.println("Total de Files Lidos Sem Exclusão: "+numberFilesNotDeleted);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return filesOld;
	}

	/**
	 * Verifica a data de criação e faz o calculo e cima dos dias parametrizado no properties
	 * @param file - File que será verificado a Data
	 * @param filesOld - List com os arquivos que passam nas validações
	 * @throws IOException
	 */
	private void verificationCreateDate(File file, List<File> filesOld) throws IOException {

		BasicFileAttributes attrs;
		attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
		FileTime time = attrs.creationTime();

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time.toMillis());
	
		c.add(Calendar.DATE, fileConfig.getDaysForDelete());

		if (c.getTimeInMillis() > calHoje.getTimeInMillis() && !file.isDirectory() && isSelectedForDeleted(file)) {
			filesOld.add(file);
			
			StringBuilder logStr = new StringBuilder();
			logStr.append("Nome arquivo: " + file.getName());
			logStr.append("\tIsDirectory: " + file.isDirectory());
			logStr.append("\tDataCriacao: " + sdf.format(c.getTime()));
			logStr.append("\tDataDaModificação: " + sdf.format(file.lastModified()));

			numberFilesDeleted++;
			
		} else {
			numberFilesNotDeleted++;
		}

	}

	/**
	 * Verifica se o File condiz com a nomenclatura dos arquivos criados pelo DMS
	 * @param file
	 * @return True - se Condiz / False = Se não condiz
	 */
	private boolean isSelectedForDeleted(File file) {

		boolean isSelectedForDelete = false;
		String fileName = file.getName();

		for (String extension : fileConfig.getExtensions()) {
			if (fileName.endsWith(extension)) {
				isSelectedForDelete = true;
				break;
			}
		}

		return isSelectedForDelete;

	}
	

}
