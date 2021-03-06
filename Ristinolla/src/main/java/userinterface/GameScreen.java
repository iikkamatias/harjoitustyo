
package userinterface;

import domain.Logic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameScreen {  

    private BorderPane gameLayout;
    private Label turn;
    private BorderPane mainLayout;
    private Logic logic;
    
    public GameScreen(BorderPane mainLayout) { 
        
        this.logic = new Logic();
        this.mainLayout = mainLayout;
        this.gameLayout = new BorderPane();
        this.turn = new Label("Turn: " + this.logic.getTurn());

        createLayout();
    }
    
    public void createLayout() {
        turn.setFont(new Font("Arial", 20));
        Label rowText = new Label("Winning row lenght is 3");
        rowText.setFont(new Font("Arial", 15));

        VBox titels = new VBox(10);
        titels.setAlignment(Pos.CENTER);
        titels.getChildren().addAll(this.turn, rowText);
        
        gameLayout.setAlignment(titels, Pos.CENTER);
        gameLayout.setTop(titels);
        
        GridPane grid = new GridPane();
 
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100, 100, 100, 100));
        
 
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button button = new Button(logic.status(x, y));
                button.setFont(Font.font("Monospaced", 35));
 
                grid.add(button, x, y);
 
                int rx = x;
                int ry = y;
 
                button.setOnAction((event) -> {
                    logic.set(rx, ry);
                    button.setText(logic.status(rx, ry));
                    turn.setText("Turn: " + logic.getTurn());
 
                    if (logic.end()) {
                        EndScreen endLayout = new EndScreen(this.mainLayout);
                        this.mainLayout.setCenter(endLayout.getEndLayout());
                    }
                });
            }
        }
        
        gameLayout.setAlignment(grid, Pos.CENTER);
        gameLayout.setCenter(grid);
        

    }
    
    public BorderPane getGameLayout() {
        return gameLayout;
    }
}
