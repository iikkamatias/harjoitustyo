
package domain;

import dao.UsernamesDao;
import java.util.ArrayList;

public class UsernamesLogic {
    
    private UsernamesDao dao;
    private String name;

    /**
     * Constructor, when Usernames aren't used for adding a new player. For example,
     * when statistics are viewed.
     *
     * @param dbname name of the sqlite-file
     *
     */
    public UsernamesLogic(String dbname) {
        this.dao = new UsernamesDao(dbname);
    }
    /**
     * Constructor for when Usernames are used for adding a new player.
     *
     * @param dbname name of the sqlite-file
     * @param name name of the player
     *
     */
    public UsernamesLogic(String name, String dbname) {

        this.dao = new UsernamesDao(dbname);
        this.name = name;
    }

    /**
     * Retrieving the usernames who have played the game
     *
     * @return an ArrayList with the names of the players
     */
    public ArrayList<String> usernames() {
        ArrayList<String> usernames = dao.usernames(this.name);
        return usernames;
    }

    /**
     * Adding a name to the table
     *
     * @param name name of the entry
     */
    public void addName(String name) {
        this.dao.insertPlayer(this.name);
    }
    
}
