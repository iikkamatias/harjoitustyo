
package userinterface;

import domain.Logic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Winner {
    private final BorderPane winnerLayout;
    private final String winner;
    private final Logic logic;
    private final BorderPane layout;
    private final boolean draw;
    private final Label warning;
    
    public Winner(Logic logic, BorderPane layout, boolean draw) {
        this.warning = new Label("");
        this.draw = draw;
        this.layout = layout;
        this.logic = logic;
        this.winnerLayout = new BorderPane();
        this.winner = this.logic.getWinner();

        createLayout();
    }
    public void createLayout() {
        Label gamewinner = new Label();
        if (this.draw) {
            gamewinner.setText("Tasapeli");
        } else {
            gamewinner.setText(this.winner + " voitit pelin!");
        }
        Insets insets = new Insets(100);
        BorderPane.setAlignment(gamewinner, Pos.CENTER);

        VBox buttons = new VBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(insets);

        BorderPane.setMargin(gamewinner, new Insets(100));
        winnerLayout.setTop(gamewinner);
        winnerLayout.setCenter(buttons);
    }

    public BorderPane getLayout() {
        return this.winnerLayout;
    }
 
}
