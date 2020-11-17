
package userinterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartmenuUi {

    private BorderPane mainLayout;
    private BorderPane startMenu;
    private TextField gridSize;
    private TextField rowSize;
    private Label warning;

    public StartmenuUi(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        this.startMenu = new BorderPane();
        this.warning = new Label("");

        createLayout();
    }

    public void createLayout() {

        startMenu.setPrefSize(500, 500);
        Insets insets = new Insets(20);
        BorderPane top = new BorderPane();

        Label titel = new Label("Tervetuloa pelaamaan ristinollaa!");
        titel.setFont(new Font("Arial", 20));
        titel.setAlignment(Pos.CENTER);

        top.setCenter(titel);
        top.setMargin(titel, insets);

        VBox textFieldLayout = new VBox(8);
        Label instructions = new Label("Kirjoita ruudukon koko ja voittosuoran pituus. \n            Ruudukon koon tulee olla 3–7 \n    Voittosuora ei voi olla ruudukkoa isompi!");
        this.gridSize = new TextField();
        this.gridSize.setPromptText("ruudukko");
        gridSize.setMaxWidth(80);
        this.rowSize = new TextField();
        this.rowSize.setPromptText("suora");
        rowSize.setMaxWidth(80);
        textFieldLayout.setAlignment(Pos.CENTER);
        this.warning.setAlignment(Pos.CENTER);
        textFieldLayout.getChildren().addAll(instructions, gridSize, rowSize, warning);

        Button chooseButton = createButton();

        startMenu.setAlignment(textFieldLayout, Pos.CENTER);
        startMenu.setAlignment(top, Pos.CENTER);
        startMenu.setAlignment(chooseButton, Pos.TOP_CENTER);
        startMenu.setMargin(chooseButton, insets);

        startMenu.setTop(top);
        startMenu.setCenter(textFieldLayout);
        startMenu.setBottom(chooseButton);

        mainLayout.setCenter(startMenu);

    }


    public int grid() {
        return Integer.valueOf(this.gridSize.getText());
    }

    public int row() {
        return Integer.valueOf(this.rowSize.getText());
    }

    public BorderPane getMainLayout() {
        return mainLayout;
    }

    public BorderPane getStartMenuLayout() {
        return this.startMenu;
    }

    private Button createButton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

} 
