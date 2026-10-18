
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
public class IuStackTest
{

//	@Generated(value = "org.junit-tools-1.0.6")
    @SuppressWarnings("unused")
    private Logger logger = Logger.getLogger(IuStackTest.class.toString());
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

    private IuStack createTestSubject()
    {
        return new IuStack();
    }

    /**
     * @param testSubject
     */
    void checkPushAndPop(IuStack testSubject)
    {
        InternetUser x = new InternetUser("example.com", InternetUser.DEFAULT_IP);
        testSubject.pushInternetUser(x);
        Assert.assertEquals(x, testSubject.popInternetUser());
//		testSubject.pushIu(x);
//		Assert.assertEquals(x, testSubject.popIu());
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "pushInternetUser", signature = "(QInternetUser;)V")
    @Test
    public void testPushInternetUser() throws Exception
    {
        IuStack testSubject;

        // default test
        testSubject = createTestSubject();
        testSubject.pushInternetUser(null);
//		testSubject.pushIu(null);
        checkPushAndPop(testSubject);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "popInternetUser", signature = "()QInternetUser;")
    @Test
    public void testPopInternetUser() throws Exception
    {
        IuStack testSubject;
        InternetUser result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.popInternetUser();
//		result = testSubject.popIu();
        Assert.assertNotNull(result);
        checkPushAndPop(testSubject);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testShowStack() throws Exception
    {
        IuStack testSubject;

        // default test
        testSubject = createTestSubject();
        String iu1name = "example.com";
        String iu1IP = InternetUser.DEFAULT_IP;
        InternetUser iu1 = new InternetUser(iu1name, iu1IP);
        testSubject.pushInternetUser(iu1);
//		testSubject.pushIu(iu1);
        String iu2name = "example.org";
        String iu2IP = "256.256.256.256";
        InternetUser iu2 = new InternetUser(iu2name, iu2IP);
        testSubject.pushInternetUser(iu2);
//		testSubject.pushIu(iu2);
        testSubject.showStack();
        // Assert.assertEquals("", outContent.toString());
        String output = outContent.toString();
        Assert.assertEquals("Developers probably forgot to override show() in IuNode", true, output.contains(iu1name));
        Assert.assertEquals(true, output.contains(iu1IP));
        Assert.assertEquals(true, output.contains(iu2name));
        Assert.assertEquals(true, output.contains(iu2IP));
    }
}