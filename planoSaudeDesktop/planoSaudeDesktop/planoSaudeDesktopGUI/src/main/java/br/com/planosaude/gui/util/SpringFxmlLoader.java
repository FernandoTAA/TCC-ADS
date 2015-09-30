package br.com.planosaude.gui.util;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.planosaude.gui.vo.SpringFxmlLoaderVO;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SpringFxmlLoader {
	
	public static Stage primaryStage;

	public static final SpringFxmlLoader LOADER = new SpringFxmlLoader();

	private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			SpringApplicationConfig.class);

	public SpringFxmlLoaderVO load(String url) {
		try (InputStream fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url)) {
			System.err.println(SpringFxmlLoader.class.getResourceAsStream(url));
			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(new Callback<Class<?>, Object>() {
				@Override
				public Object call(Class<?> clazz) {
					return applicationContext.getBean(clazz);
				}
			});
			return new SpringFxmlLoaderVO(loader.load(fxmlStream), loader.getController());
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}
}
