
package userinterface;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameUi extends Application {

    BorderPane mainLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Ristinolla peli");

        this.mainLayout = new BorderPane();
        StartmenuUi startmenu = new StartmenuUi(this.mainLayout);
        BorderPane layout = startmenu.getMainLayout();

        Scene nakyma = new Scene(layout);
        stage.setScene(nakyma);
        stage.show();
    }

}
