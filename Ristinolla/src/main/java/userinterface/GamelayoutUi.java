
package userinterface;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public final class GamelayoutUi {

    private final BorderPane gameLayout;
    private final GridUi gamegrid;
    private final Label turn;
    private final BorderPane mainLayout;
    private final int row;

    public GamelayoutUi(int size, int row, BorderPane mainLayout) {
        this.row = row;
        this.mainLayout = mainLayout;
        this.gameLayout = new BorderPane();
        this.gamegrid = new GridUi(size, row, this, mainLayout);
        this.turn = new Label("Vuorossa: " + this.gamegrid.getTurn());

        createLayout();
    }

    public void createLayout() {
        turn.setFont(new Font("Arial", 25));
        Label rowText = new Label("Voittosuoran pituus on " + this.row);
        rowText.setFont(new Font("Arial", 10));

        VBox titels = new VBox(15);
        titels.setAlignment(Pos.CENTER);
        titels.getChildren().addAll(this.turn, rowText);

        BorderPane.setAlignment(titels, Pos.CENTER);
        gameLayout.setTop(titels);

        GridPane grid = gamegrid.getGameGrid();

        BorderPane.setAlignment(grid, Pos.CENTER);
        gameLayout.setCenter(grid);

    }

    public BorderPane getLayout() {
        return gameLayout;
    }

    public void setTurn(String turn) {
        this.turn.setText("Vuorossa: " + this.gamegrid.getTurn());
    }
    
}
