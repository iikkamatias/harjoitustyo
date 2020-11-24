
import domain.AppLogic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    AppLogic logic;
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        logic = new AppLogic(3, 3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void XHasFirstTurn() {
        assertEquals("X", logic.getTurn());
    }

    @Test
    public void SecondTurnIs0() {
        logic.changeTurn();
        assertEquals("0", logic.getTurn());
    }
        @Test
    public void DuringFirstTurnScoreboardSetsX() {
        logic.updateScore(0, 0);
        assertEquals("X", logic.getSymbolFromScoreBoard(0, 0));
    }

    @Test
    public void DuringTheSecondTurnScoreboardSets0() {
        logic.changeTurn();
        logic.updateScore(0, 0);
        assertEquals("0", logic.getSymbolFromScoreBoard(0, 0));
    }
    @Test
    public void GameIsNotEndingEarlyColumns() {
        logic.updateScore(0, 0);
        logic.updateScore(1, 2);
        logic.updateScore(2, 0);
        assertEquals(false, logic.isThereAWinnerInColumns(2, 0));
    }

    @Test
    public void GameIsNotEndingEarlyInRows() {
        logic.updateScore(0, 0);
        logic.updateScore(1, 2);
        logic.updateScore(0, 1);
        assertEquals(false, logic.isThereAWinnerInRows(0, 1));
    }
    
    @Test
    public void GamesEndsWhenSymbolsAreInTheRow() {
        logic.updateScore(0, 0);
        logic.updateScore(0, 1);
        logic.updateScore(0, 2);
        assertEquals(true, logic.isThereAWinnerInRows(0, 2));
    }

    @Test
    public void GamesEndsWhenSymbolsAreinTheColumn() {
        logic.updateScore(0, 0);
        logic.updateScore(1, 0);
        logic.updateScore(2, 0);
        assertEquals(true, logic.isThereAWinnerInColumns(2, 0));
    }
}
