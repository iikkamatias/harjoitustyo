
package userinterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public final class StartmenuUi {

    private final BorderPane mainLayout;
    private final BorderPane startMenu;
    private TextField gridSize;
    private TextField rowSize;
    private final Label warning;

    public StartmenuUi(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        this.startMenu = new BorderPane();
        this.warning = new Label("");

        createLayout();
    }

    public void createLayout() {

        startMenu.setPrefSize(600, 600);
        Insets insets = new Insets(25);
        BorderPane top = new BorderPane();

        Label titel = new Label("Pelataan ristinollaa!");
        titel.setFont(new Font("Arial", 25));
        titel.setAlignment(Pos.CENTER);

        top.setCenter(titel);
        BorderPane.setMargin(titel, insets);

        VBox textFieldLayout = new VBox(15);
        Label instructions = new Label("Kirjoita ruudukon koko ja voittavan suoran pituus. \n Voittosuora ei voi olla ruudukkoa isompi!");
        this.gridSize = new TextField();
        this.gridSize.setPromptText("Ruudukon koko");
        gridSize.setMaxWidth(150);
        this.rowSize = new TextField();
        this.rowSize.setPromptText("Voitto suoran pituus");
        rowSize.setMaxWidth(150);
        textFieldLayout.setAlignment(Pos.CENTER);
        this.warning.setAlignment(Pos.CENTER);
        textFieldLayout.getChildren().addAll(instructions, gridSize, rowSize, warning);

        Button chooseButton = createButton();

        BorderPane.setAlignment(textFieldLayout, Pos.CENTER);
        BorderPane.setAlignment(top, Pos.CENTER);
        BorderPane.setAlignment(chooseButton, Pos.TOP_CENTER);
        BorderPane.setMargin(chooseButton, insets);

        startMenu.setTop(top);
        startMenu.setCenter(textFieldLayout);
        startMenu.setBottom(chooseButton);

        mainLayout.setCenter(startMenu);

    }

    public Button createButton() {
        Button sizesChosen = new Button("Pelaamaan");

        sizesChosen.setOnAction((actionEvent -> {
            try {
                if (grid() > 2 && grid() >= row() && row() > 2 && grid() < 8) {
                    GamelayoutUi gameLayout;
                    gameLayout = new GamelayoutUi(grid(), row(), mainLayout);
                    mainLayout.setCenter(gameLayout.getLayout());

                } else {
                    this.warning.setText("Tarkista ruudukon ja voittavan suoran koko");
                }
            } catch (NumberFormatException e) {
                this.warning.setText("Käytä numeroita!");
            }
        }));

        return sizesChosen;
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

}
