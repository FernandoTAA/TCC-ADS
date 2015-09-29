package br.com.planosaude.gui.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXUtils {

	public static Stage generateDialogStage(String title, Parent root, Stage primaryStage) {
		Stage dialogStage = new Stage();
		dialogStage.setTitle(title);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(root);
		dialogStage.setScene(scene);
		return dialogStage;
	}

}
