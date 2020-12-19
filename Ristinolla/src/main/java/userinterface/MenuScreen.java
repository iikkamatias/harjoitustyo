
package userinterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public final class MenuScreen {
    private final BorderPane mainLayout;
    private final BorderPane menu;
    private TextField nickname;

    public MenuScreen(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        this.menu = new BorderPane();

        createLayout();
    }

    public void createLayout() {
        menu.setPrefSize(600, 600);
        Insets insets = new Insets(20);
        BorderPane top = new BorderPane();

        Label titel = new Label("Let's Play Ristinolla!");
        titel.setFont(new Font("Arial", 20));
        titel.setAlignment(Pos.CENTER);

        top.setCenter(titel);

        Button playButton = createPlayButton();
        Button endButton = endGameButton();
        
        menu.setAlignment(titel, Pos.CENTER);
        menu.setAlignment(playButton, Pos.CENTER);
        menu.setAlignment(endButton, Pos.TOP_CENTER);
        menu.setMargin(playButton, insets);
        menu.setMargin(endButton, insets);
        
        menu.setTop(top);
        menu.setCenter(playButton);
        menu.setBottom(endButton);

        mainLayout.setCenter(menu);
    }
    
    public Button createPlayButton() {
        Button playButton = new Button("Lets Play");

        playButton.setOnAction((actionEvent -> {
            GameScreen gameLayout;
            gameLayout = new GameScreen(mainLayout);
            mainLayout.setCenter(gameLayout.getGameLayout());

        }));

        return playButton;
    }
    
    public Button endGameButton() {
        Button endButton = new Button("End Game");

        endButton.setOnAction((actionEvent -> {
            EndScreen endLayout;
            endLayout = new EndScreen(mainLayout);
            mainLayout.setCenter(endLayout.getEndLayout());

        }));

        return endButton;
    }
    
    public BorderPane getMainLayout() {
        return this.mainLayout;
    }
}

