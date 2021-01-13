//package clique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launcher extends Application {
    
    public static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/FXML_Clique.fxml"));

        Scene scene = new Scene(root);
        String css = Launcher.class.getResource("/pageAccueil.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        primaryStage.setTitle("Application_Clique");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
