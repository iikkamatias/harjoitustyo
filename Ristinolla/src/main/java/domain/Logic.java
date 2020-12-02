
package domain;

import java.util.Arrays;

public class Logic {
 
    private String[][] game;
    private String turn;
    private String winner;
 
    public Logic() {
        this.game = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        this.turn = "X";
    }
 
    public String status(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return "";
        }
 
        return this.game[x][y];
    }
 
    public void set(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return;
        }
 
        if (!this.game[x][y].equals(" ")) {
            return;
        }
 
        if (end()) {
            return;
        }
 
        this.game[x][y] = this.turn;
 
        if (this.turn.equals("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
 
    }
 
    public boolean end() {
        int[][] same = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},
            {6, 4, 2},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}
        };
 
        for (int i = 0; i < same.length; i++) {
            if (inTheSameTable(same[i])) {
                this.winner = this.turn;
                return true;
            }
        }
 
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (status(x, y).trim().isEmpty()) {
                    this.winner = "NOBODY";
                    return false;
                }
            }
        }
 
        return true;
    }
 
    public String getTurn() {
        return this.turn;
    }
 
    private boolean inTheSameTable(int[] table) {
        String[] values = {valueInTable(table[0]), valueInTable(table[1]), valueInTable(table[2])};
        Arrays.sort(values);
        return values[0].equals(values[1]) && values[1].equals(values[2]) && !values[0].trim().isEmpty();
    }
 
    private String valueInTable(int spot) {
        int x = spot % 3;
        int y = spot / 3;
        return this.game[x][y];
    }
    
    public String getWinner() {
        return this.winner;
    }
 
}