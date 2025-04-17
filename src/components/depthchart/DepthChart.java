package components.depthchart;

/**
 * DepthChart interface.
 */
public interface DepthChart extends DepthChartKernel {


    /**
     * Returns the size of this.
     * @return the number of players in this.
     * @ensures numPlayers = |this|.
     */
    int numPlayers();

    /**
     * Prints the offensive personnel to the terminal according to football
     * personnel (10 = 1 hb 0 te, 4 wr; 12 = 1 hb, 2 te, 2 wr; etc.).
     * @param personnel the personel to print.
     * @requires personnel is in the list <10, 11, 12, 13, 14, 20, 21, 22, 23,
     * 30, 31, 32>
     * @ensures the players in the personnel grouping are printed to the
     * terminal.
     */
    void printOffensivePersonnel(int personnel);

    /**
     * Prints the defensive personnel to the terminal according to football
     * personnel (nickel = 5 dbs, dime = 6 dbs, baseThreeFour = 4 dbs, etc.).
     * @param personnel the personel to print.
     * @requires personel is in the list <nickel, dime, dollar, baseThreeFour,
     * baseFourThree>
     * @ensures the players in the personnel grouping are printed to the
     * terminal.
     */
    void printDefensivePersonnel(String personnel);

    /**
     * Adds the players in players to position.
     * @param players array of player names to be added.
     * @param position position to add players to.
     * @updates this.
     * @requires <qb, hb, fb, wr, te, ot, og,
     *           c, de, dt, ilb, olb, cb, fs, ss, ls, k, p>.
     * @ensures this.position = revPlayers + #this.position.
     */
    void addPlayers(String[] players, String position);
}

