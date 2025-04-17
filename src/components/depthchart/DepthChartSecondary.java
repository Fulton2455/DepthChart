import java.util.Iterator;

/**
 * Abstract class implementation.
 */
public abstract class DepthChartSecondary implements DepthChart {

    @Override
    public int numPlayers() {
        int result = 0;
        Iterator<String> positions = this.orderedPositionIterator();
        while (positions.hasNext()) {
            String position = positions.next();
            result += this.numPosition(position);
        }
        return result;
    }

    @Override
    public void printOffensivePersonnel(int personnel) {
        final int divisor = 10;
        final int numSkill = 5;

        int numTE = personnel % divisor;
        int numHB = personnel / divisor;
        int numWR = numSkill - (numTE + numHB);

        this.printAndRestore("qb", 1);
        this.printAndRestore("hb", numHB);
        this.printAndRestore("wr", numWR);
        this.printAndRestore("te", numTE);
        this.printAndRestore("ot", 1);
        this.printAndRestore("og", 1);
        this.printAndRestore("c", 1);
    }

    /**
     * Helper method for printing a player and restoring them back to the stack.
     *
     * @param position
     *      Position to print and restore from
     * @param count
     *      number of players to print and restore
     *
     */
    private void printAndRestore(String position, int count) {
        if (this.numPosition(position) >= count) {
            String[] temp = new String[count];
            for (int i = 0; i < count; i++) {
                temp[i] = this.removePlayer(position);
                System.out.println(temp[i]);
            }
            for (int i = count - 1; i >= 0; i--) {
                this.addPlayer(temp[i], position);
            }
        } else {
            System.out.println("Error, you do not have enough " + position
                    + "s to print this personnel.");
        }
    }

    @Override
    public void printDefensivePersonnel(String personnel) {
        final int zero = 0;
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        // IDL (Interior Defensive Linemen)
        this.printAndRestore("idl", 2);

        // EDGE (Edge rushers)
        this.printAndRestore("edge", 2);

        // Determine number of linebackers
        int numLBs = zero;
        if (personnel.equals("baseFourThree")) {
            numLBs = three;
        } else if (personnel.equals("nickel")) {
            numLBs = two;
        } else if (personnel.equals("dime")) {
            numLBs = one;
        }
        this.printAndRestore("lb", numLBs);

        int numCBs = five;
        if (personnel.equals("baseFourThree")) {
            numCBs = two;
        } else if (personnel.equals("nickel")) {
            numCBs = three;
        } else if (personnel.equals("dime")) {
            numCBs = four;
        }
        this.printAndRestore("cb", numCBs);

        // Safeties (2 always)
        this.printAndRestore("s", 2);
    }


    @Override
    public void addPlayers(String[] players, String position) {
        for (String player : players) {
            this.addPlayer(player, position);
        }

    }
}

