package br.com.planosaude.batch.launcher;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.planosaude.batch.util.SpringUtils;

/**
 * Classe que inicia o processamento de sincronismo da atualização cadastral das
 * pessoas.
 * 
 * @author FernandoTAA
 *
 */
public class AtualizacaoCadastralJobLauncher {

	private static final Logger LOGGER = Logger.getLogger(AtualizacaoCadastralJobLauncher.class);

	/**
	 * Metodo que inicia o processamento iniciando com o escopo correto do
	 * Spring e inicia o {@link Job}.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"classpath:/config/atualizacaoCadastralResources.xml");
		SpringUtils.setApplicationContext(appContext);
		runJob(appContext);
	}

	/**
	 * Metodo que recupra o {@link Job} do escopo do Spring e executa cada
	 * {@link Step}.
	 * 
	 * @param appContext
	 */
	private static void runJob(final ClassPathXmlApplicationContext appContext) {
		final Job appJob = (Job) appContext.getBean("atualizacaoCadastralJobLauncherJob");
		final JobLauncher jobLauncher = (JobLauncher) appContext.getBean("jobLauncher");

		try {
			LOGGER.info("Batch inicializado");
			final long tempoExecucao = System.currentTimeMillis();
			// Executa o Job, de forma sï¿½ncrona
			final JobExecution result = jobLauncher.run(appJob, new JobParameters());
			LOGGER.info("Tempo de execucao do batch: " + (System.currentTimeMillis() - tempoExecucao) / 1000
					+ " segundo(s)");
			// Lista os steps executados, e seus status de conclusï¿½o
			final Collection<StepExecution> steps = result.getStepExecutions();
			for (final StepExecution step : steps) {
				LOGGER.info("**************************************************************");
				LOGGER.info("Step executado: " + step.getStepName());
				LOGGER.info("Start em : " + step.getStartTime());
				LOGGER.info("Fim em : " + step.getEndTime());
				LOGGER.info("Status execucao : " + step.getStatus());
				LOGGER.info("**************************************************************");
			}
		} catch (final JobExecutionAlreadyRunningException e) {
			LOGGER.error(e, e);
		} catch (final JobRestartException e) {
			LOGGER.error(e, e);
		} catch (final JobInstanceAlreadyCompleteException e) {
			LOGGER.error(e, e);
		} catch (final JobParametersInvalidException e) {
			LOGGER.error(e, e);
		}
	}
}