
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IntPairTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntPairTest
{
    /**
     * Default constructor for test class IntPairTest
     */
    public IntPairTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * 
     */
    @Test
    public void nullConstructorTest()
    {
        IntPair intPair1 = new IntPair();
        assertEquals("(0, 0)", intPair1.toString());
    }

    /**
     * 
     */
    @Test
    public void longConstructorTest()
    {
        IntPair intPair1 = new IntPair(541, 1223);
        assertEquals("(541, 1223)", intPair1.toString());
    }
}
