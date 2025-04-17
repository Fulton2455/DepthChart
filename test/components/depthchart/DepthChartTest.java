import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases of DepthChart.
 */
public class DepthChartTest {

    /**
     * Chart to be tested on.
     */
    private DepthChart2 chart;

    /**
     * Runs before each test to reset the chart.
     */
    @Before
    public void setUp() {
        this.chart = new DepthChart2();
    }

    /**
     * Test of add multiple players.
     */
    @Test
    public void testAddPlayers() {
        String[] players = {"A", "B", "C"};
        this.chart.addPlayers(players, "wr");

        assertEquals(3, this.chart.numPosition("wr"));
        assertEquals(3, this.chart.numPlayers());
    }

    /**
     * Test of numPlayers at different positions.
     */
    @Test
    public void testNumPlayersAcrossPositions() {
        this.chart.addPlayer("QB", "qb");
        this.chart.addPlayer("WR1", "wr");
        this.chart.addPlayer("WR2", "wr");
        this.chart.addPlayer("TE", "te");

        assertEquals(4, this.chart.numPlayers());
    }

    /**
     * Test of printOffensivePersonnel.
     */
    @Test
    public void testPrintOffensivePersonnel() {
        // Setup
        this.chart.addPlayer("QB", "qb");
        this.chart.addPlayer("HB", "hb");
        this.chart.addPlayer("WR1", "wr");
        this.chart.addPlayer("WR2", "wr");
        this.chart.addPlayer("WR3", "wr");
        this.chart.addPlayer("TE", "te");
        this.chart.addPlayer("OT", "ot");
        this.chart.addPlayer("OG", "og");
        this.chart.addPlayer("C", "c");

        // Capture output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        this.chart.printOffensivePersonnel(11); // 1 HB, 1 TE => 3 WRs

        String output = out.toString().trim();
        assertTrue(output.contains("QB"));
        assertTrue(output.contains("HB"));
        assertTrue(output.contains("WR1"));
        assertTrue(output.contains("WR2"));
        assertTrue(output.contains("WR3"));
        assertTrue(output.contains("TE"));

        // Restore console
        System.setOut(System.out);
    }

    /**
     * Test of printDefensivePersonnel.
     */
    @Test
    public void testPrintDefensivePersonnelNickel() {
        // Setup
        String[] idls = {"IDL1", "IDL2"};
        String[] edges = {"EDGE1", "EDGE2"};
        String[] lbs = {"LB1", "LB2"};
        String[] cbs = {"CB1", "CB2", "CB3"};
        String[] ss = {"S1", "S2"};

        this.chart.addPlayers(idls, "idl");
        this.chart.addPlayers(edges, "edge");
        this.chart.addPlayers(lbs, "lb");
        this.chart.addPlayers(cbs, "cb");
        this.chart.addPlayers(ss, "s");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        this.chart.printDefensivePersonnel("nickel");

        String output = out.toString().trim();
        assertTrue(output.contains("IDL1"));
        assertTrue(output.contains("EDGE1"));
        assertTrue(output.contains("LB1"));
        assertTrue(output.contains("CB1"));
        assertTrue(output.contains("S1"));

        // Restore console
        System.setOut(System.out);
    }

    /**
     * Test of printOffensivePersonnel missing positions.
     */
    @Test
    public void testPrintOffensivePersonnelNotEnoughPlayers() {
        // Not adding a center
        this.chart.addPlayer("QB", "qb");
        this.chart.addPlayer("HB", "hb");
        this.chart.addPlayer("WR", "wr");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        this.chart.printOffensivePersonnel(11);

        String output = out.toString().trim();
        assertTrue(output.contains("Error, you do not have enough c"));
        System.setOut(System.out);
    }

    /**
     * Test of printDefensivePersonnel missing positions.
     */
    @Test
    public void testPrintDefensivePersonnelErrorMessage() {
        // Missing safeties
        this.chart.addPlayer("IDL1", "idl");
        this.chart.addPlayer("IDL2", "idl");
        this.chart.addPlayer("EDGE1", "edge");
        this.chart.addPlayer("EDGE2", "edge");
        this.chart.addPlayer("LB1", "lb");
        this.chart.addPlayer("CB1", "cb");
        this.chart.addPlayer("CB2", "cb");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        this.chart.printDefensivePersonnel("baseFourThree");

        String output = out.toString().trim();
        assertTrue(output.contains("Error, you do not have enough s"));

        System.setOut(System.out);
    }
}
