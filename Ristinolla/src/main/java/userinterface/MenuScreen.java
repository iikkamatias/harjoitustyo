
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
        titel.setFont(new Font("Arial", 25));
        titel.setAlignment(Pos.CENTER);

        top.setCenter(titel);
        BorderPane.setMargin(titel, insets);

        VBox textFieldLayout = new VBox(15);
        Label instructions = new Label("Write your name");
        this.nickname = new TextField();
        this.nickname.setPromptText("Players nickname");
        nickname.setMaxWidth(150);
        textFieldLayout.setAlignment(Pos.CENTER);
        textFieldLayout.getChildren().addAll(instructions, nickname);

        BorderPane.setAlignment(textFieldLayout, Pos.CENTER);
        BorderPane.setAlignment(top, Pos.CENTER);

        menu.setTop(top);
        menu.setTop(textFieldLayout);

        mainLayout.setCenter(menu);
        
        Button playButton = createPlayButton();
        
        BorderPane.setAlignment(playButton, Pos.TOP_CENTER);
        BorderPane.setMargin(playButton, insets);
        menu.setCenter(playButton);
        
        Button endButton = endGameButton();
        
        BorderPane.setAlignment(endButton, Pos.TOP_CENTER);
        BorderPane.setMargin(endButton, insets);
        menu.setBottom(endButton);


    }
    
    public Button createPlayButton() {
        Button playButton = new Button("Lets Play");

        playButton.setOnAction((actionEvent -> {
            GameScreen gameLayout;
            gameLayout = new GameScreen();
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

