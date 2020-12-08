
package userinterface;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EndScreen {
    private final BorderPane endGameLayout;
    private final BorderPane mainLayout;
    
    public EndScreen(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        this.endGameLayout = new BorderPane();

        createLayout();
    }
    
    public void createLayout() {
        Label gameEnded = new Label();
        gameEnded.setText("Game Ended your name is added to database");

        Insets insets = new Insets(100);
        BorderPane.setAlignment(gameEnded, Pos.CENTER);

        VBox buttons = new VBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(insets);

        BorderPane.setMargin(gameEnded, new Insets(100));
        endGameLayout.setTop(gameEnded);
        endGameLayout.setCenter(buttons);
        
        Button menuButton = menuButton();
        
        BorderPane.setAlignment(menuButton, Pos.TOP_CENTER);
        BorderPane.setMargin(menuButton, insets);
        endGameLayout.setBottom(menuButton);
    }
    
        public Button menuButton() {
        Button toMenu = new Button("Back to menu");

        toMenu.setOnAction((event -> {
            MenuScreen menuLayout;
            menuLayout = new MenuScreen(mainLayout);
            mainLayout.setCenter(menuLayout.getMainLayout());
        }));

        return toMenu;
    }

    public BorderPane getEndLayout() {
        return this.endGameLayout;
    }
 
}
