
package userinterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public final class Menu {
    private final BorderPane layout;
    private final BorderPane menu;
    private TextField gridSize;
    private TextField rowSize;
    private final Label warning;

    public Menu(BorderPane mainLayout) {
        this.layout = mainLayout;
        this.menu = new BorderPane();
        this.warning = new Label("");

        createLayout();
    }

    public void createLayout() {

        menu.setPrefSize(600, 600);
        Insets insets = new Insets(25);
        BorderPane top = new BorderPane();

        Label titel = new Label("Let's Play!");
        titel.setFont(new Font("Arial", 25));
        titel.setAlignment(Pos.CENTER);

        top.setCenter(titel);
        BorderPane.setMargin(titel, insets);

        VBox textFieldLayout = new VBox(15);
        Label instructions = new Label("Kirjoita pelaajan nimi");
        this.gridSize = new TextField();
        this.gridSize.setPromptText("Pelaajan nimi");
        gridSize.setMaxWidth(150);
        textFieldLayout.setAlignment(Pos.CENTER);
        this.warning.setAlignment(Pos.CENTER);
        textFieldLayout.getChildren().addAll(instructions, gridSize, rowSize, warning);

        BorderPane.setAlignment(textFieldLayout, Pos.CENTER);
        BorderPane.setAlignment(top, Pos.CENTER);

        menu.setTop(top);
        menu.setCenter(textFieldLayout);

        layout.setCenter(menu);

    }
}

