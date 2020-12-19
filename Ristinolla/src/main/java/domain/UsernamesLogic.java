/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.UsernameDao;
import java.util.ArrayList;

/**
 *
 * @author iikka
 */
public class UsernamesLogic {
    
    private UsernameDao dao;
    private String name;

    /**
     * Constructor for when Usernames aren't used for adding a game. For example,
     * when statistics are viewed.
     *
     * @param dbname name of the sqlite-file
     *
     */
    public UsernamesLogic(String dbname) {
        this.dao = new UsernameDao(dbname);
    }
    /**
     * Constructor for when Usernames aren't used for adding a game. For example,
     * when statistics are viewed.
     *
     * @param dbname name of the sqlite-file
     *
     */
    public UsernamesLogic(String name, String dbname) {

        this.dao = new UsernameDao(dbname);
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
     * Adding a name to the table with other information given in the
     * constructor
     *
     * @param name name of the entry
     */
    public void addName(String name) {
        this.dao.insertPlayer(this.name);
    }
    
}
