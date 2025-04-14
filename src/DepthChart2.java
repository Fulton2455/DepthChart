import java.util.*;

/*Convention:-Each key in{@code re
 * } corresponds  The order of players in the stack for each position represents
 *  their depth chart ranking:the player
 * Correpondence: A DepthChart2 represents a mapping from position strings
 * (e.g., "qb", "wr") to a depth-ordered stack of player names (most recent
 * addition = starter).
 */
public class DepthChart2 extends DepthChartSecondary {

    /**
     * Representation of this.
     */
    private Map<String, Stack<String>> rep;

    /**
     * Ordered list for iterator.
     */
    static final List<String> ORDERED_POSITIONS = List.of("qb", "hb", "fb",
            "wr", "te", "ot", "og", "c", "dt", "de", "ilb", "olb", "cb", "fs",
            "ss", "k", "p", "ls");

    @Override
    public DepthChart2() {
        this.rep = new HashMap<>();
        for (String position : ORDERED_POSITIONS) {
            this.rep.put(position, new Stack<>());
        }
    }

    @Override
    public final void addPlayer(String player, String position) {
        this.rep.get(position).push(player);
    }

    @Override
    public final String removePlayer(String position) {
        return this.rep.get(position).pop();
    }

    @Override
    public final int numPosition(String position) {
        return this.rep.get(position).size();
    }

    /**
     * Need to update interface to reflect this.
     */
    @Override
    public Iterator<String> orderedPositionIterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < ORDERED_POSITIONS.size();
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return ORDERED_POSITIONS.get(index++);
            }
        };
    }
}
