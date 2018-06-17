package br.com.dmsexpurgo;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DmsExpurgoApplication{
	
	private static String[] args;
	
	
    @Autowired
    JobLauncher jobLauncher;


	public static void main(String[] args) {
		setArgs(args);
		SpringApplication.run(DmsExpurgoApplication.class, args);
	}

	@Scheduled(cron = "* 0/1 * * * ?",zone = "America/Sao_Paulo")
	public void restartar() {
		
//		DmsExpurgoApplication dmsExpurgo = new DmsExpurgoApplication();
//		dmsExpurgo.main(args);
		
//		testarArquivos();
		
		System.out.println("Restart");
//		JobParametersBuilder jobParameters = new JobParametersBuilder()
//				.addLong("currentTime", new Long(System.currentTimeMillis()));
//		
//		BatchConfiguration b = new BatchConfiguration();
//		try {
//			jobLauncher.run(b.exportPessoaJob(), jobParameters.toJobParameters());
//		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
//				| JobParametersInvalidException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//SpringApplication.run(DmsExpurgoApplication.class, args);
	}
	

	public static String[] getArgs() {
		return args;
	}

	public static void setArgs(String[] args) {
		DmsExpurgoApplication.args = args;
	}

	

}
