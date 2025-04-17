import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for DepthChart2 implementation.
 */
public class DepthChart2Test {

    /**
     * General DepthChart to use in tests.
     */
    private DepthChart2 chart;

    /**
     * Runs before each of the test cases to reset the chart variable.
     */
    @Before
    public void setUp() {
        this.chart = new DepthChart2();
    }

    /**
     * Test adding a single player.
     */
    @Test
    public void testAddPlayer() {
        this.chart.addPlayer("Tom Brady", "qb");
        assertEquals(1, this.chart.numPosition("qb"));
    }

    /**
     * Test removing a player.
     */
    @Test
    public void testRemovePlayer() {
        this.chart.addPlayer("Tom Brady", "qb");
        String removed = this.chart.removePlayer("qb");
        assertEquals("Tom Brady", removed);
        assertEquals(0, this.chart.numPosition("qb"));
    }

    /**
     * Test numPosition on multiple players.
     */
    @Test
    public void testNumPositionMultiplePlayers() {
        this.chart.addPlayer("Player 1", "wr");
        this.chart.addPlayer("Player 2", "wr");
        assertEquals(2, this.chart.numPosition("wr"));
    }

    /**
     * Test iterator.
     */
    @Test
    public void testOrderedPositionIterator() {
        Iterator<String> it = this.chart.orderedPositionIterator();
        assertTrue(it.hasNext());
        assertEquals("qb", it.next());
    }

    /**
     * test clear.
     */
    @Test
    public void testClear() {
        this.chart.addPlayer("Player A", "te");
        this.chart.clear();
        assertEquals(0, this.chart.numPosition("te"));
    }

    /**
     * test transferFrom.
     */
    @Test
    public void testTransferFrom() {
        DepthChart2 chart2 = new DepthChart2();
        chart2.addPlayer("Backup QB", "qb");
        this.chart.transferFrom((DepthChart) chart2);

        assertEquals(1, this.chart.numPosition("qb"));
        assertEquals(0, chart2.numPosition("qb")); // Should be cleared
    }

    /**
     * test newInstance.
     */
    @Test
    public void testNewInstance() {
        DepthChart newChart = this.chart.newInstance();
        assertNotSame(this.chart, newChart);
        assertTrue(newChart instanceof DepthChart2);
    }
}
