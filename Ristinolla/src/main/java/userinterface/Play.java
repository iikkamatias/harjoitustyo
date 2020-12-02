
package userinterface;

import domain.Logic;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Play {
     
    public void play(Stage stage) throws Exception {
        Logic game = new Logic();
 
        Font equalWidth = Font.font("Monospaced", 40);
 
        Label gameProgress = new Label("Turn: " + game.getTurn());
        gameProgress.setFont(equalWidth);
 
        BorderPane layout = new BorderPane();
        layout.setTop(gameProgress);
 
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
 
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button button = new Button(game.status(x, y));
                button.setFont(equalWidth);
 
                grid.add(button, x, y);
 
                int rx = x;
                int ry = y;
 
                button.setOnAction((event) -> {
                    game.set(rx, ry);
                    button.setText(game.status(rx, ry));
                    gameProgress.setText("Turn: " + game.getTurn());
 
                    if (game.end()) {
                        gameProgress.setText("End");
                    }
                });
            }
        }
    }
    
}
