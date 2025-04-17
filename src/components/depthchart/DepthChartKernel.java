package components.depthchart;

import java.util.Iterator;

/**
 * DepthChartKernel Interface.
 */
public interface DepthChartKernel extends Standard<DepthChart> {

    /**
     * Adds player as starter in position.
     *
     * @param player
     *            the name of the player to be added
     * @param position
     *            The name of the position to add the player
     * @updates this
     * @requires Position is included in the list, <qb, hb, fb, wr, te, ot, og,
     *           c, de, dt, ilb, olb, cb, fs, ss, ls, k, p>
     * @ensures this.position = player + #this.position
     */
    void addPlayer(String player, String position);

    /**
     * Removes the player from this.position.
     *
     * @param position
     *            the position to remove the player from
     * @updates this
     * @return the player removed.
     * @requires Position is included in the list, <qb, hb, fb, wr, te, ot, og,
     *           c, de, dt, ilb, olb, cb, fs, ss, ls, k, p> && |position| > 0.
     * @ensures #this.position = player + this.position
     */
    String removePlayer(String position);

    /**
     * Returns the size of position.
     *
     * @param position
     *            the position to return the size of.
     * @return number of players in position.
     * @requires Position is included in the list, <qb, hb, fb, wr, te, ot, og,
     *           c, de, dt, ilb, olb, cb, fs, ss, ls, k, p>
     * @ensures number of players = |position|
     */
    int numPosition(String position);

    /**
     * Cutom iterator that prints the positions in order (qb, rb, fb, wr, etc.).
     *
     * @return Iterator<String> an iterator over each of the positins in this.
     *
     */
    Iterator<String> orderedPositionIterator();
}
