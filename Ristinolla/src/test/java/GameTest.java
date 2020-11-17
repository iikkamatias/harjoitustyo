
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
}
