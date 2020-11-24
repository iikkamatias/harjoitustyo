
package userinterface;

import domain.AppLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public final class WinnerUi {

    private final BorderPane winnerLayout;
    private final String winner;
    private final AppLogic appLogic;
    private final BorderPane mainLayout;
    private final boolean draw;
    private final Label warning;

    public WinnerUi(AppLogic appLogic, BorderPane mainLayout, boolean draw) {
        this.warning = new Label("");
        this.draw = draw;
        this.mainLayout = mainLayout;
        this.appLogic = appLogic;
        this.winnerLayout = new BorderPane();
        this.winner = this.appLogic.getWinner();

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
