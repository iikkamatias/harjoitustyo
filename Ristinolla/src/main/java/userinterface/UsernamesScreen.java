
package userinterface;

import domain.UsernamesLogic;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UsernamesScreen {
    private BorderPane mainLayout;
    private BorderPane usernamesLayout;
    private UsernamesLogic usernamesLogic;
    private VBox namesLayout;
    
    /**
     * Creates a layout for the Usernames view.
     *
     * @param mainLayout mainlayout of the app, usernamesLayout will be set to it.
     * @param usernamesLogic usernamesLogic
     */
    public UsernamesScreen(BorderPane mainLayout, UsernamesLogic usernamesLogic) {
        this.namesLayout = new VBox(10);
        this.usernamesLogic = usernamesLogic;
        this.mainLayout = mainLayout;
        this.usernamesLayout = new BorderPane();

        createUsernamesLayout();
    }
    
    /**
     * Creates a layout for List of Players.
     *
     */
    public void createUsernamesLayout() {
        Insets insets = new Insets(20);
        Label titel = new Label("Names of the players who have played this game");
        titel.setFont(new Font("Arial", 20));


        VBox titels = new VBox(10);

        titels.setAlignment(Pos.CENTER);
        titels.getChildren().addAll(titel);

        Button toMenu = toStartMenu();

        this.usernamesLayout.setAlignment(toMenu, Pos.TOP_CENTER);
        this.usernamesLayout.setMargin(toMenu, insets);

        this.usernamesLayout.setTop(titels);
        this.usernamesLayout.setBottom(toMenu);
        this.usernamesLayout.setCenter(this.namesLayout);
    }
    

    
    public Button toStartMenu() {
        Button toStart = new Button("Back to menu");

        toStart.setAlignment(Pos.CENTER);

        toStart.setOnAction((actionEvent -> {
            MenuScreen startMenu = new MenuScreen(this.mainLayout);
            this.mainLayout.setCenter(startMenu.getMainLayout());
        }));

        return toStart;
    }
    
    public BorderPane listEntry(int rank, String name) {
        BorderPane entryLayout = new BorderPane();
        entryLayout.setMaxWidth(125);
        Label rankName = new Label(rank + 1 + ".  " + name);

        rankName.setAlignment(Pos.CENTER_LEFT);

        entryLayout.setLeft(rankName);

        return entryLayout;
    }
    
    /**
     * Updates the view with the the method setUsernames().
     */
    public void updateList() {
        this.usernamesLayout.getChildren().removeAll(this.usernamesLayout.getChildren());
    }
    
    public BorderPane getUsernamesLayout() {
        return this.usernamesLayout;
    }

}
