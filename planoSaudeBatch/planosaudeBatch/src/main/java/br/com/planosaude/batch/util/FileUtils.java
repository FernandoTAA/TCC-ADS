package br.com.planosaude.batch.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Classe Utilitaria para manipulação de arquivos.
 * 
 * @author FernandoTAA
 *
 */
public class FileUtils {

	private final static Logger LOGGER = Logger.getLogger(FileUtils.class);

	/**
	 * Salva o arquivo com o nome do arquivo presente na {@code fileName} o
	 * conteúdo presente no parametro {@code fileContent}.
	 * 
	 * @param fileName - {@link String} com nome do arquivo.
	 * @param fileContent - {@link String} com o conteudo do arquivo.
	 */
	public static void salvarArquivo(String fileName, String fileContent) {
		BufferedWriter bw = null;
		try {
			FileWriter fw = new FileWriter(new File(fileName), true);

			bw = new BufferedWriter(fw);
			bw.write(fileContent);
			bw.newLine();
		} catch (IOException e) {
			LOGGER.error("ERRO ao salvar o arquivo.", e);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					LOGGER.error("ERRO ao fechar o arquivo.", e);
				}
			}
		}
	}

}
