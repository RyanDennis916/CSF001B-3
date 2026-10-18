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

//@Generated(value = "org.junit-tools-1.0.6")

/**
 * 
 */
public class IuNodeTest
{

    private static final String testName = "foothill.edu";
    private static final String testIP = "153.18.96.219";

//	@Generated(value = "org.junit-tools-1.0.6")
    @SuppressWarnings("unused")
    private Logger logger = Logger.getLogger(IuNodeTest.class.toString());
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

    private IuNode createTestSubject()
    {
        return new IuNode(null);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "getData", signature = "()QInternetUser;")
    @Test
    public void testGetData() throws Exception
    {
        IuNode testSubject;
        InternetUser result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getData();
        Assert.assertNotNull(result);
        Assert.assertEquals(InternetUser.DEFAULT_IP, result.getIp());

        InternetUser testIU = new InternetUser(testName, testIP);
        testSubject = new IuNode(testIU);
        result = testSubject.getData();
        Assert.assertEquals(testIU, result);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        IuNode testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.toString();
        Assert.assertNotNull(result);
        Assert.assertEquals(result + " should have inside it: " + InternetUser.DEFAULT_IP, true,
                result.contains(InternetUser.DEFAULT_IP));

        InternetUser testIU = new InternetUser(testName, testIP);
        testSubject = new IuNode(testIU);
        result = testSubject.toString();
        Assert.assertEquals(true, result.contains(testName));
        Assert.assertEquals(true, result.contains(testIP));
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "show", signature = "()V")
    @Test
    public void testShow() throws Exception
    {
        IuNode testSubject;

        // default test
        testSubject = createTestSubject();
        testSubject.show();
        Assert.assertEquals(outContent.toString() + " should have inside it: " + InternetUser.DEFAULT_IP, true,
                outContent.toString().contains(InternetUser.DEFAULT_IP));
    }
}