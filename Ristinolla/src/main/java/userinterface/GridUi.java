
package userinterface;

import domain.AppLogic;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public final class GridUi {
    private final GridPane grid;
    private final AppLogic applogic;
    private final int size;
    private final GamelayoutUi layout;
    private final BorderPane mainLayout;

    public GridUi(int size, int row, GamelayoutUi layout, BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        this.layout = layout;
        this.size = size;
        this.applogic = new AppLogic(size, row);
        this.grid = new GridPane();

        creatingGrid();
    }

    public void creatingGrid() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Button button = createButton(i, j);
                grid.add(button, j, i);
            }
        }

        this.grid.setAlignment(Pos.CENTER);
    }

    public Button createButton(int x, int y) {
        Button button = new Button(" ");
        button.setFont(Font.font("Monospaced", 30));

        button.setOnAction((actionEvent) -> {
            if (this.applogic.spaceEmpty(x, y)) {
                this.applogic.updateScore(x, y);
                button.setText(this.applogic.getTurn());
                String turn = this.applogic.changeTurn();
                this.layout.setTurn(turn);

                if (this.applogic.isThereAWinner(x, y)) {
                    WinnerUi winnerLayout = new WinnerUi(this.applogic, this.mainLayout, false);
                    this.mainLayout.setCenter(winnerLayout.getLayout());

                } else if (this.applogic.scoreboardFull()) {
                    WinnerUi winnerLayout = new WinnerUi(this.applogic, this.mainLayout, true);
                    this.mainLayout.setCenter(winnerLayout.getLayout());

                }
            }
        });

        return button;
    }

    public GridPane getGameGrid() {
        return grid;
    }

    public String getTurn() {
        return this.applogic.getTurn();
    }

}

