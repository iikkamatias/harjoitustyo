
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsernameDao {
    

    private Connection connection;
    private PreparedStatement stmt;
    private Statement s;
    private String dbname;

    /**
     * Sets the name of the file that id used to store the data. Using the
     * method initializeDB() creates a new table if one doesn't exist.
     */
    
    public UsernameDao(String dbname) {
        this.dbname = dbname;

        initializeDB();

    }

    /**
     * Creates a new table for games, if it doesn't already exist.
     */
    public void initializeDB() {
        try {
            startConnection();
            s.execute("CREATE TABLE IF NOT EXISTS Usernames (id INTEGER PRIMARY KEY, username TEXT NOT NULL);");
            closeConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while creating the table!");
        }
    }

    /**
     * Starts a new connection to the database.
     */
    public void startConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbname);
            s = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting!");
        }
    }

    /**
     * Closes the connection to an connected database.
     */
    public void closeConnection() {
        try {
            s.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while closing the connection!");
        }
    }

    /**
     * Inserts a new player to the table.
     *
     * @param name name of the player.
     */
    public void insertPlayers(String name) {
        try {
            startConnection();
            stmt = connection.prepareStatement("INSERT INTO Usernames (name) VALUES (?);");
            stmt.setString(1, name);
            stmt.executeUpdate();
            stmt.close();
            closeConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while adding the player to the table!");
        }
    }

    /**
     * Gets the usernames whom have played the game.
     *
     * @return Usernames from the table as an ArrayList
     */
    public ArrayList<String> usernames(String name) {
        try {
            startConnection();
            stmt = connection.prepareStatement("SELECT name");
            stmt.setString(1, name);
            ResultSet usernames = stmt.executeQuery();

            ArrayList<String> names = new ArrayList<>();

            while (usernames.next()) {
                names.add(usernames.getString("name"));
            }

            closeConnection();
            return names;
        } catch (SQLException e) {
            System.out.println("An error occurred while searching for the usernames!");
            return null;
        }
    }

    /**
     * Clears the connected table.
     */
    public void clear() {
        try {
            startConnection();
            s.execute("DROP TABLE IF EXISTS Usernames;");
            closeConnection();
            initializeDB();
        } catch (SQLException e) {
            System.out.println("An error occurred while clearing the table!");
        }
    }

    public void insertPlayer(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
