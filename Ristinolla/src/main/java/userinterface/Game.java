
package userinterface;


import domain.Logic;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class Game extends Application {
    
    BorderPane mainLayout;
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Ristinolla");
 
        this.mainLayout = new BorderPane();
        MenuScreen startmenu = new MenuScreen(this.mainLayout);
        BorderPane layout = startmenu.getMainLayout();

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}