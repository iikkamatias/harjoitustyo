
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
    /**
     * Class for database.
     */
public class UsernamesDao {
    

    private String database;

    /**
     * Sets the name of the file that id used to store the data. Using the
     * method initializeDB() creates a new table if one doesn't exist.
     */
    
    public UsernamesDao(String database) {
        this.database = database;

    }

    /**
     * Creates a new table for games, if it doesn't already exist.
     */
    public void createDB() {
        Connection db = createConnection();
        try {
            Statement s = db.createStatement();
            s.execute("BEGIN TRANSACTION");
            s.execute("CREATE TABLE Usernames (id INTEGER PRIMARY KEY, username TEXT UNIQUE NOT NULL);");

            
            db.close();
        } catch (SQLException e) {
            return;
        }
    }
        /**
     * Adding new user to database.
     * @param user username of the user.
     * @return returns true if adding user succeeds, false otherwise, like in case of the username already being reserved.
     */
    public boolean addUser(String user) {
        if (containsUser(user)) {
            return false;
        }
        
        Connection db = createConnection();

        try {
            PreparedStatement p = db.prepareStatement("INSERT INTO Usernames (username) VALUES (?)");
            p.setString(1, user);
        
            p.execute();
        
            db.close();
        
        } catch (SQLException e) {
            System.out.println("Exception in addUser: " + e);
            return false;
        }
        return true;
    }
     /**
     * Checking if database already contains the username.
     * @param user username which will be checked if database contains it.
     * @return returns true if username is already in database, false otherwise.
     */
    public boolean containsUser(String user) {
        Connection db = createConnection();
        
        try {
            PreparedStatement check = db.prepareStatement("SELECT Usernames.username FROM Usernames WHERE Usernames.username=?");
            check.setString(1, user);
        
            ResultSet r = check.executeQuery();
        
            db.close();
            return r.next();
        } catch (SQLException e) {
            return false;
        }
    }
    private int getUserId(String user) {
        if (!containsUser(user)) {
            return -1;
        }
        
        Connection db = createConnection();
        
        try {
            PreparedStatement p = db.prepareStatement("SELECT Usernames.id FROM Usernames WHERE Usernames.username=?");
            p.setString(1, user);
        
            ResultSet r = p.executeQuery();
        
            r.next();
            int userId = r.getInt("id");
            
            db.close();
            return userId;
        } catch (SQLException e) {
            return -1;
        }    
    }
    public void emptyTables() {
        Connection db = createConnection();
        
        try {
            
            PreparedStatement emptyUsernames = db.prepareStatement("DELETE FROM Usernames");
            emptyUsernames.executeUpdate();
            
            db.close();
        } catch (SQLException e) {
            System.out.println("SQLException" + e);
        }
    }

    /**
     * Starts a new connection to the database.
     */
    private Connection createConnection() {
        try {
            Connection db = DriverManager.getConnection(this.database);
            return db;
        } catch (SQLException e) {
            return null;
        }
    }

}
