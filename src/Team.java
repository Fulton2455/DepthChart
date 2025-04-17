import java.util.Iterator;
/**
 * Sample use cases.
 */
public class Team {

    /**
     *
     * @param team
     *      Team to print the lineup of.
     * @param offensivePersonnel
     *      Offensive personnel to start in
     * @param defensivePersonnel
     *      Defensive personnel to start in
     * @requires offensivePersonnel is in <10, 11, 12, 13, 14, 20, 21, 22, 23,
     * 30, 31, 32, 40, 41, 50> and defensivePersonnel is in <baseFourThree,
     * nickel, dime, dollar>.
     */
    public static void printStartingLineup(DepthChart team,
    int offensivePersonnel, String defensivePersonnel) {

        System.out.println("Today's Starting Offense: \n");
        team.printOffensivePersonnel(offensivePersonnel);
        System.out.println("Today's Starting Defense: \n");
        team.printDefensivePersonnel(defensivePersonnel);
    }
    /**
    *
    * @param team
    *       team to retrieve starter from.
    * @param position
            position to retrieve starter from.
    * @return
    *        first string at position.
    */
    public static String getStarter(DepthChart team, String position) {
        String starter = team.removePlayer(position);
        team.addPlayer(starter, position);
        return starter;
    }

    /**
     *
     * @param team
     *      Team to check for player.
     * @param player
     *      Player to check for.
     * @return
     *      true if the player is present in team, false if not.
     */
    public static boolean containsPlayer(DepthChart team, String player) {
        boolean found = false;
        Iterator<String> positions = team.orderedPositionIterator();

        while (positions.hasNext() && !found) {
            String position = positions.next();
            int size = team.numPosition(position);
            String[] temp = new String[size];

            int i = 0;
            while (i < size && !found) {
                temp[i] = team.removePlayer(position);
                if (temp[i].equals(player)) {
                    found = true;
                }
                i++;
            }

            // Only restore what was removed
            for (int j = i - 1; j >= 0; j--) {
                team.addPlayer(temp[j], position);
            }
        }

        return found;
    }
}
