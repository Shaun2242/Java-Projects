import acsse.csc2a.nova.gui.SolarSystemDisplayBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SolarSystemDisplayBox root = new SolarSystemDisplayBox(800,500);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Solar System Viewer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
