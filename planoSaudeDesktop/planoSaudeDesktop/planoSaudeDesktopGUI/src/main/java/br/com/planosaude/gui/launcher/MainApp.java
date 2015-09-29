package br.com.planosaude.gui.launcher;

import br.com.planosaude.gui.constant.FXConstants;
import br.com.planosaude.gui.util.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		SpringFxmlLoader.primaryStage = primaryStage; 
		Parent root = SpringFxmlLoader.LOADER.load(FXConstants.CONSULTA_PESSOA).getParent();
		Scene scene = new Scene(root, 600, 400);
		SpringFxmlLoader.primaryStage.setScene(scene);
		SpringFxmlLoader.primaryStage.setTitle("Consulta de Pessoas");
		SpringFxmlLoader.primaryStage.getIcons().add(new Image(FXConstants.FAVICON_PATCH));
		SpringFxmlLoader.primaryStage.show();
	}
	
	public static void main(String[] args) {
	  launch(args);
	}
}
