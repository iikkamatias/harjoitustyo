
import domain.Logic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogicTest {
    Logic logic;
    
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        logic = new Logic();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void XHasFirstTurn() {
        assertEquals("X", logic.getTurn());
    }
    
    @Test
    public void StatusIsCorrectWhenXIsNegative() {
        assertEquals("", logic.status(-1, 1));
    }
    
        @Test
    public void StatusIsCorrectWhenYIsNegative() {
        assertEquals("", logic.status(1, -1));
    }
    
    @Test
    public void StatusIsCorrectWhenXIsOver2() {
        assertEquals("", logic.status(3, 1));
    }
    
    @Test
    public void StatusIsCorrectWhenYIsOver2() {
        assertEquals("", logic.status(1, 3));
    }
    
    @Test
    public void StatusIsCorrect() {
        assertEquals(" ", logic.status(1, 1));
    }

    @Test
    public void DoesntEndTooEarly() {
        assertEquals(false, logic.end());
    }
    
    @Test
    public void EndCorreclyWhenWinnerRow() {
        logic.set(0,0);
        logic.set(1,1);
        logic.set(1,0);
        logic.set(1,2);
        logic.set(2,0);
        assertEquals(true, logic.end());
    }
    @Test
    public void EndCorreclyWhenWinnerColumn() {
        logic.set(0,0);
        logic.set(1,1);
        logic.set(0,1);
        logic.set(1,2);
        logic.set(0,2);
        assertEquals(true, logic.end());
    }
    
    @Test
    public void EndCorreclyWhenTied() {
        logic.set(0,0);
        logic.set(0,2);
        logic.set(0,1);
        logic.set(1,0);
        logic.set(1,2);
        logic.set(1,1);
        logic.set(2,0);
        logic.set(2,2);
        logic.set(2,1);
        System.out.println(logic.getWinner());
        assertEquals(true, logic.end());
    }
    
    @Test
    public void GetTurnCorrectly() {
        logic.set(1, 0);
        assertEquals("O", logic.getTurn());
    } 

    @Test
    public void GetWinnerCorrectly() {
        logic.set(0,0);
        logic.set(1,1);
        logic.set(0,1);
        logic.set(1,2);
        logic.set(0,2);
        assertEquals("NOBODY", logic.getWinner());
    }
    
}
