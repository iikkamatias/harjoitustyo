
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dao.UsernamesDao;

public class DaoTest {
     UsernamesDao dao;
    
    public DaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.dao = new UsernamesDao("jdbc:sqlite:testdatabase.db");
        this.dao.createDB();
    }
    
    @After
    public void tearDown() {
        this.dao.emptyTables();
    }
    
    @Test
    public void usernamesDaoExists() {
        assertTrue(this.dao!=null);
    }
    
    @Test
    public void usernameThatHasntBeenAddedDoesntExist() {
        assertEquals(false, this.dao.containsUser("Höpö"));
    }
    
    @Test
    public void addingUsernameCorrectly() {
        this.dao.addUser("Löpö");
        
        assertEquals(false, this.dao.containsUser("Löpö"));
    }

}
