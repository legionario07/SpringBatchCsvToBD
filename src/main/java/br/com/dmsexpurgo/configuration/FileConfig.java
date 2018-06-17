package br.com.dmsexpurgo.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties("files-config")
@Validated
public class FileConfig {

	private String pathFile;
	private String pattern;
	private String regex;
	private Integer daysForDelete;
	private List<String> extensions;
	private Integer splitIndexInvoiceId;
	private Integer splitIndexIsUnlimitedService;
	private String timesForCycle;
	private String timeZone;


	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public Integer getDaysForDelete() {
		return daysForDelete;
	}

	public void setDaysForDelete(Integer daysForDelete) {
		this.daysForDelete = daysForDelete;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public List<String> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<String> extensions) {
		this.extensions = extensions;
	}

	public Integer getSplitIndexInvoiceId() {
		return splitIndexInvoiceId;
	}

	public void setSplitIndexInvoiceId(Integer splitIndexInvoiceId) {
		this.splitIndexInvoiceId = splitIndexInvoiceId;
	}

	public Integer getSplitIndexIsUnlimitedService() {
		return splitIndexIsUnlimitedService;
	}

	public void setSplitIndexIsUnlimitedService(Integer splitIndexIsUnlimitedService) {
		this.splitIndexIsUnlimitedService = splitIndexIsUnlimitedService;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getTimesForCycle() {
		return timesForCycle;
	}

	public void setTimesForCycle(String timesForCycle) {
		this.timesForCycle = timesForCycle;
	}

}
