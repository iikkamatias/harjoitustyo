
package userinterface;


import domain.UsernamesLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EndScreen {
    private final BorderPane endGameLayout;
    private final BorderPane mainLayout;
    private UsernamesLogic usernamesLogic;
    private Label warning;
    
    public EndScreen(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        this.endGameLayout = new BorderPane();
        this.warning = new Label("");

        createLayout();
    }
    
    public void createLayout() {
        Label gameEnded = new Label();

        Insets insets = new Insets(100);
        BorderPane.setAlignment(gameEnded, Pos.CENTER);

        VBox buttons = new VBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(insets);

        BorderPane.setMargin(gameEnded, new Insets(100));
        endGameLayout.setTop(gameEnded);
        endGameLayout.setCenter(buttons);
        
        Button gameButton = gameButton();
        
        BorderPane.setAlignment(gameButton, Pos.TOP_CENTER);
        BorderPane.setMargin(gameButton, insets);
        endGameLayout.setCenter(gameButton);
        
        Button menuButton = menuButton();
        
        BorderPane.setAlignment(menuButton, Pos.TOP_CENTER);
        BorderPane.setMargin(menuButton, insets);
        endGameLayout.setBottom(menuButton);
        
        TextField nickname = nameField();
        buttons.getChildren().addAll(new Text("Your name is added to database!"), nickname, addUsernameButton(nickname), this.warning);

        BorderPane.setAlignment(nickname, Pos.TOP_CENTER);
        BorderPane.setMargin(nickname, new Insets(50));
        endGameLayout.setTop(nickname);
        endGameLayout.setCenter(buttons);

    }
    
    public Button menuButton() {
        Button toMenu = new Button("Back to menu");

        toMenu.setOnAction((event -> {
            MenuScreen menuLayout;
            menuLayout = new MenuScreen(mainLayout);
            menuLayout.getMainLayout();
        }));

        return toMenu;
    }
        
    public Button gameButton() {
        Button toGame = new Button("Play again");

        toGame.setOnAction((event -> {
            GameScreen gameLayout;
            gameLayout = new GameScreen(mainLayout);
            gameLayout.getGameLayout();
        }));

        return toGame;
    }
        /**
     * Creates a button to go to the usernames view.Adds username to the database
     * @param name sets username
     * @return returns lists
     */
    public Button addUsernameButton(TextField name) {
        Button toLists = new Button("Add username!");

        toLists.setAlignment(Pos.CENTER);

        toLists.setOnAction((actionEvent -> {
            if (!name.getText().equals("")) {
                this.warning.setText("Not Supported yet try later!");
            } else {
                this.warning.setText("This field cannot be empty!");
            }

        }));

        return toLists;
    }

    public BorderPane getEndLayout() {
        return this.endGameLayout;
    }
    
    public TextField nameField() {
        TextField name = new TextField();
        name.setPromptText("nickname");
        name.setAlignment(Pos.CENTER);
        name.setMaxWidth(120);

        return name;
    }
 
}
