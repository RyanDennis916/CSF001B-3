
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

//import javax.annotation.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import static org.junit.Assert.*;

//@Generated(value = "org.junit-tools-1.0.6")
/**
 * 
 */
@SuppressWarnings("unused")
public class IntegrationStackTest
{

//	@Generated(value = "org.junit-tools-1.0.6")
    @SuppressWarnings("unused")
    private Logger logger = Logger.getLogger(IntegrationStackTest.class.toString());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private final PrintStream err = System.err;
    /**
     * Sequence used by operating system to separate lines in text files
     */
    public static String newLine = System.getProperty("line.separator");

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception
    {
        System.setOut(out);
        System.setErr(err);
    }

    /**
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    /**
     * 
     */
    @Test
    public void testFullIntegration()
    {
        IuStack testSubject = new IuStack();
        testSubject.push(new IuNode(new InternetUser()));
        testSubject.push(new IuNode(new InternetUser("qwerty", "0.9.8.7")));

        for (int i = 0; i < 3; i++)
        {
            System.out.println(testSubject.popInternetUser());
//			System.out.println(testSubject.popIu());
        }
        String expected = "Name: qwerty" + newLine + "IP Address: 0.9.8.7" + newLine + newLine + newLine
                + "Name: (undefined)" + newLine + "IP Address: 0.0.0.0" + newLine + newLine + newLine
                + "Name: (undefined)" + newLine + "IP Address: 0.0.0.0" + newLine + newLine + newLine;
        Assert.assertEquals(expected, outContent.toString());
        Assert.assertTrue("The output content should start with the expected String.",
                outContent.toString().startsWith(expected));
        Assert.assertEquals("There should be no error content.", "", errContent.toString());
    }
}