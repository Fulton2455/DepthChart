
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Javadoc.
 */
public class DepthChart implements Iterable<Map.Entry<String, Stack<String>>> {
    /**
     * Reptresentation of {@code this}.
     */
    private Map<String, Stack<String>> rep;

    /**
     * Constructor creates an empty depth chart.
     */
    public DepthChart() {
        this.rep = new HashMap<String, Stack<String>>();
        Stack<String> qb = new Stack<>();
        this.rep.put("qb", qb);
        Stack<String> hb = new Stack<>();
        this.rep.put("hb", hb);
        Stack<String> fb = new Stack<>();
        this.rep.put("fb", fb);
        Stack<String> wr = new Stack<>();
        this.rep.put("wr", wr);
        Stack<String> te = new Stack<>();
        this.rep.put("te", te);
        Stack<String> ot = new Stack<>();
        this.rep.put("ot", ot);
        Stack<String> og = new Stack<>();
        this.rep.put("og", og);
        Stack<String> c = new Stack<>();
        this.rep.put("c", c);
        Stack<String> dt = new Stack<>();
        this.rep.put("dt", dt);
        Stack<String> de = new Stack<>();
        this.rep.put("de", de);
        Stack<String> ilb = new Stack<>();
        this.rep.put("ilb", ilb);
        Stack<String> olb = new Stack<>();
        this.rep.put("olb", olb);
        Stack<String> cb = new Stack<>();
        this.rep.put("cb", cb);
        Stack<String> fs = new Stack<>();
        this.rep.put("fs", fs);
        Stack<String> ss = new Stack<>();
        this.rep.put("ss", ss);
        Stack<String> k = new Stack<>();
        this.rep.put("k", k);
        Stack<String> p = new Stack<>();
        this.rep.put("p", p);
        Stack<String> ls = new Stack<>();
        this.rep.put("ls", ls);

    }

    /**
     * Adds the player to the position (Kernel).
     */
    public final void addPlayer(String player, String position) {
        Stack<String> positionStack = this.rep.get(position);
        positionStack.push(player);
    }

    /**
     * Removes the player from the position (Kernel).
     */
    public final String removePlayer(String position) {
        Stack<String> positionStack = this.rep.get(position);
        String player = positionStack.pop();
        return player;
    }

    /**
     * Returns the size of one position (Kernel).
     */
    public final int numPosition(String position) {
        Stack<String> positionStack = this.rep.get(position);
        return positionStack.size();
    }

    /**
     * Custom iterator that prints in alphabetical order of positions.
     */
    @Override
    public Iterator<Map.Entry<String, Stack<String>>> iterator() {
        List<Map.Entry<String, Stack<String>>> sortedEntries = new ArrayList<>(
                this.rep.entrySet());

        // Sort by alphabetical order: would want to make this specific order
        //(ie qb, hb, fb, wr) but will work on later.
        sortedEntries.sort(Comparator.comparing(Map.Entry::getKey));

        return sortedEntries.iterator();
    }

    /**
     * Returns the size of the whole roster (Probably Not Kernel).
     */
    public final int numPlayers() {
        int totalPlayers = 0;
        for (Map.Entry<String, Stack<String>> x : this) {
            totalPlayers += this.numPosition(x.getKey());
        }
        return totalPlayers;
    }

    /**
     * Main Method.
     *
     * @param args
     *
     */
    public static void main(String[] args) {

        /**
         * Create a depth chart and give it players Consider a new way to add
         * players in bulk because this is very tedious, perhaps input a String
         * array and have it insert all of those names into a position
         */
        DepthChart myTeam = new DepthChart();
        myTeam.addPlayer("Caleb Williams", "qb");
        myTeam.addPlayer("D'andre Swift", "hb");
        myTeam.addPlayer("Khari Blasingame", "fb");
        myTeam.addPlayer("Rome Odunze", "wr");
        myTeam.addPlayer("Keenan Allen", "wr");
        myTeam.addPlayer("DJ Moore", "wr");
        myTeam.addPlayer("Cole Kmet", "te");
        myTeam.addPlayer("Larry Borom", "ot");
        myTeam.addPlayer("Teven Jenkins", "og");
        myTeam.addPlayer("Coleman Shelton", "c");
        myTeam.addPlayer("Matt Pryor", "og");
        myTeam.addPlayer("Darnell Wright", "ot");
        myTeam.addPlayer("Montez Sweat", "de");
        myTeam.addPlayer("Zacch Pickens", "dt");
        myTeam.addPlayer("Gervon Dexter", "dt");
        myTeam.addPlayer("Demarcus Walker", "de");
        myTeam.addPlayer("TJ Edwardst", "olb");
        myTeam.addPlayer("Tremaine Edmunds", "ilb");
        myTeam.addPlayer("Jack Sanborn", "olb");
        myTeam.addPlayer("Jaylon Johnson", "cb");
        myTeam.addPlayer("Tyrique Stevenson", "cb");
        myTeam.addPlayer("Kyler Gordon", "cb");
        myTeam.addPlayer("Kevin Byard", "fs");
        myTeam.addPlayer("Jaquan Brisker", "ss");
        myTeam.addPlayer("Cairo Santos", "k");
        myTeam.addPlayer("Tory Taylor", "p");
        myTeam.addPlayer("Scott Daly", "ls");

        //Check to see if position sizes and total size is working
        System.out.println(myTeam.numPosition("wr"));
        System.out.println(myTeam.numPosition("qb"));
        String wrOnes = myTeam.removePlayer("wr");
        System.out.println(wrOnes);
        System.out.println(myTeam.numPosition("wr"));
        myTeam.addPlayer(wrOnes, "wr");
        System.out
                .println("Number of players on roster: " + myTeam.numPlayers());
        /**
         * //code for printing the starting lineup a secondary method //sure to
         * be included should really build an iterator to help with this
         * System.out.println("Today's starting lineup:");
         * System.out.println("Offense:"); String qb =
         * myTeam.removePlayer("qb"); System.out.println(qb);
         * myTeam.addPlayer(qb, "qb"); String hb = myTeam.removePlayer("hb");
         * System.out.println(hb); myTeam.addPlayer(hb, "hb"); String wrOne =
         * myTeam.removePlayer("wr"); System.out.println(wrOne); String wrTwo =
         * myTeam.removePlayer("wr"); System.out.println(wrTwo); String wrThree
         * = myTeam.removePlayer("wr"); System.out.println(wrThree);
         * myTeam.addPlayer(wrThree, "wr"); myTeam.addPlayer(wrTwo, "wr");
         * myTeam.addPlayer(wrOne, "wr"); String te = myTeam.removePlayer("te");
         * System.out.println(te); myTeam.addPlayer(te, "te"); String otL =
         * myTeam.removePlayer("ot"); System.out.println(otL); String otR =
         * myTeam.removePlayer("ot"); System.out.println(otR);
         * myTeam.addPlayer(otR, "ot"); myTeam.addPlayer(otL, "ot"); String ogL
         * = myTeam.removePlayer("og"); System.out.println(ogL); String ogR =
         * myTeam.removePlayer("og"); System.out.println(ogR);
         * myTeam.addPlayer(ogR, "og"); myTeam.addPlayer(ogL, "og"); String c =
         * myTeam.removePlayer("c"); System.out.println(c); myTeam.addPlayer(c,
         * "c"); //And continue for defense and special teams //Will need to
         * streamline this proccess somehow
         */

        //Better way to print all of the first players at each position but
        //need to add logic to account for positions with multiple players that
        //start. Additionally should update the iterator to order by position.
        System.out.println("\nStarting lineup:");
        for (Map.Entry<String, Stack<String>> entry : myTeam) {
            String player = entry.getValue().pop();
            System.out.println(player);
            entry.getValue().push(player);
        }
    }
}