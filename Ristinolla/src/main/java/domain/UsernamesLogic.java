
package domain;

import dao.UsernamesDao;
import java.util.ArrayList;

public class UsernamesLogic {
    
    private UsernamesDao dao;

    /**
     * Constructor, when Usernames are used for adding a new player.
     *
     * @param dbname name of the sqlite-file
     *
     */
    public UsernamesLogic(String dbname) {
        this.dao = new UsernamesDao(dbname);
    }

    /**
     * Adding a name to the table
     *
     * @param name name of the entry
     */
    public void addName(String name) {
        this.dao.addUser(name);
    }
    
}
