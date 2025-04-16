import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

/*Convention:-Each key in{@code re
 * } corresponds  The order of players in the stack for each position represents
 *  their depth chart ranking:the player
 * Correpondence: A DepthChart2 represents a mapping from position strings
 * (e.g., "qb", "wr") to a depth-ordered stack of player names (most recent
 * addition = starter).
 */
public class DepthChart2 implements DepthChartKernel {

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

    @Override
    public final DepthChart newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /**
     * Creates intitial representation.
     */
    private void createNewRep() {
        this.rep = new Map<String, Stack<String>>;
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(DepthChart source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof NaturalNumber3 : ""
                + "Violation of: source is of dynamic type NaturalNumberExample";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        DepthChart localSource = (DepthChart2) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

}
