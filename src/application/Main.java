package application;
	
import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//--------------------------
			Slider slider = new Slider(0, 1, 0);
			slider.setValue(0.6);
			ProgressBar bar = new ProgressBar(0);
			bar.setMaxWidth(Double.MAX_VALUE);
			bar.setProgress(0.8);
			//bar.progressProperty().bind(slider.valueProperty());
			slider.valueProperty().bind(bar.progressProperty());
			VBox root = new VBox(slider, bar);
			root.setPadding(new Insets(10.0));
			root.setSpacing(10.0);
			//--------------------------
			/*
			 * Scene scene = new Scene(root,400,400);
			 * scene.getStylesheets().add(getClass().getResource("application.css").
			 * toExternalForm()); primaryStage.setScene(scene);
			 */
			
			Slider sliderPies = new Slider(0, 100, 0);
			sliderPies.setShowTickMarks(true);
			sliderPies.setShowTickLabels(true);
			
			NumberBinding pulgadas = sliderPies.valueProperty().multiply(12);
			NumberBinding metros = sliderPies.valueProperty().multiply(.3048);

			TextField txtPulgadas = new TextField();
			txtPulgadas.textProperty().bind(pulgadas.asString("En pulgadas: %.2f"));

			TextField txtMetros = new TextField();
			txtMetros.textProperty().bind(metros.asString("En metros: %.2f"));
			
			VBox vbxConvertidor = new VBox(sliderPies, txtPulgadas, txtMetros);
			vbxConvertidor.setPadding(new Insets(10, 20, 30, 40));
			vbxConvertidor.setSpacing(10);
			
			Scene scnConvertidor = new Scene(vbxConvertidor,400,400);
			primaryStage.setScene(scnConvertidor);	
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
