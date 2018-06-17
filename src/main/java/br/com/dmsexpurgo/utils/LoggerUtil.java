package br.com.dmsexpurgo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.LoggerConfig;

@Component
public class LoggerUtil {

	@Autowired
	LoggerConfig loggerConfig;
	
	
	public String getDateFormatter(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(loggerConfig.getDateFormat());
		return sdf.format(date);
	}
	
}
