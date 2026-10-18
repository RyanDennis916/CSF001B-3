
import java.util.logging.Logger;

//import javax.annotation.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import mockit.Deencapsulation;

//@Generated(value = "org.junit-tools-1.0.6")
/**
 * 
 */
@SuppressWarnings("unused")
public class InternetUserTest
{
    private static final String DEFAULT_IP =
        Deencapsulation.getField(InternetUser.class, "DEFAULT_IP");
    private static final int MAX_NAME_LENGTH =
        Deencapsulation.getField(InternetUser.class, "MAX_NAME_LENGTH");
    private static final int MIN_IP_LENGTH =
        Deencapsulation.getField(InternetUser.class, "MIN_IP_LENGTH");


//	@Generated(value = "org.junit-tools-1.0.6")
    @SuppressWarnings("unused")
    private Logger logger = Logger.getLogger(InternetUserTest.class.toString());
    private int MAX_IP4_LEN = 50;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {

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

    }

    /**
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    private InternetUser createTestSubject()
    {
        return new InternetUser();
    }

    /**
     * Tests constructors
     * 
     * @throws Exception
     */
    @MethodRef(name = "InternetUser", signature = "(QString;)Z,(QString;)Z")
    @Test
    public void testInternetUser() throws Exception
    {
        InternetUser testSubject;
        String defaultName = "(undefined)"; // Assignment 4 instructions did not specify a default name
        String name = "";
        boolean result;

        // test that there is a default IP as specified
        Assert.assertNotNull("There should be a default IP as specified.", DEFAULT_IP);

        // test null constructor protected InternetUser()
        testSubject = createTestSubject();
        String actualDefaultIP = testSubject.getIp();
        Assert.assertEquals(DEFAULT_IP, actualDefaultIP);
        defaultName = testSubject.getName();
        Assert.assertNotNull("The constructor should set some non-null default name", defaultName);

        // tests for constructor protected InternetUser(String name, String ip)
        testSubject = new InternetUser(defaultName, DEFAULT_IP);
        actualDefaultIP = testSubject.getIp();
        name = testSubject.getName();
        if (!DEFAULT_IP.equals(actualDefaultIP))
        {
            // Constructor may have been implemented with IP parameter first and name
            // parameter second
            if (!defaultName.equals(actualDefaultIP))
            {
                Assert.fail("2 parameter construtor didn't set the IP.");
            }
        }
        if (!defaultName.equals(defaultName))
        {
            // Constructor may have been implemented with IP parameter first and name
            // parameter second
            if (!DEFAULT_IP.equals(defaultName))
            {
                Assert.fail("2 parameter construtor didn't set the name.");
            }
        }

        try
        {
            testSubject = new InternetUser(null, null);
            Assert.fail("A NullPointerException should have been thrown because of an invalid name or an invalid IP.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
            // A NullPointerException should have been thrown because of an invalid name or
            // an invalid IP.
        }

        try
        {
            testSubject = new InternetUser(null, "");
            Assert.fail("A NullPointerException should have been thrown because of an invalid name.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
            // A NullPointerException should have been thrown because of an invalid name.
        }

        try
        {
            testSubject = new InternetUser("", null);
            Assert.fail("A NullPointerException should have been thrown because of an invalid IP.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
            // A NullPointerException should have been thrown because of an invalid IP.
        }

        testSubject = new InternetUser("", "");
        actualDefaultIP = testSubject.getIp();
        Assert.assertEquals(DEFAULT_IP, actualDefaultIP);
        name = testSubject.getName();
        Assert.assertNotNull(name);
        Assert.assertEquals(true, name instanceof String);
        Assert.assertEquals(true, name.length() >= 2);
        Assert.assertEquals(true, name.length() <= MAX_NAME_LENGTH);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "setName", signature = "(QString;)Z")
    @Test
    public void testSetName() throws Exception
    {
        InternetUser testSubject;
        String name = "";
        boolean result;
        final String DEFAULT_NAME = "(undefined)"; // Default name was not specified

        // test setting empty String
        testSubject = createTestSubject();
        result = testSubject.setName(name);
        Assert.assertEquals(false, result);

        // test setting 1 character String
        testSubject = createTestSubject();
        name = ".";
        result = testSubject.setName(name);
        Assert.assertEquals(false, result);

        // test setting null
        name = null;
        try
        {
            result = testSubject.setName(name);
            Assert.fail("Expected a NullPointerException for trying to set the name to null.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
        }

        // test setting a name that is too large
        name = DEFAULT_NAME;
        for (int i = 0; name.length() < MAX_NAME_LENGTH + 1; ++i)
        {
            name = name + "X";
        }
        result = testSubject.setName(name);
        Assert.assertEquals(false, result);

        // test setting DEFAULT_NAME
        name = DEFAULT_NAME;
        result = testSubject.setName(name);
        Assert.assertEquals(true, result);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "setIp", signature = "(QString;)Z")
    @Test
    public void testSetIp() throws Exception
    {
        InternetUser testSubject;
        String ip = "";
        boolean result;

        // test empty String
        testSubject = createTestSubject();
        result = testSubject.setIp(ip);
        Assert.assertEquals(false, result);
        ip = null;
        try
        {
            result = testSubject.setIp(ip);
            Assert.fail("Expected a NullPointerException for trying to set the name to null.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
        }
        ip = DEFAULT_IP;
        result = testSubject.setIp(ip);
        Assert.assertEquals(true, result);

        // test a String that is too large
        testSubject = createTestSubject();
        String tooBigIP = "";
        for (int i = 0; i < MAX_IP4_LEN + 1; ++i)
        {
            tooBigIP = tooBigIP + "0";
        }
        ip = tooBigIP;
        result = testSubject.setIp(ip);
        Assert.assertEquals(false, result);

        // test a String that is just large enough
        testSubject = createTestSubject();
        String bigEnoughIP = "";
        for (int i = 0; i < MIN_IP_LENGTH; ++i)
        { // The MIN_IP_LENGTH constant's name was
          // specified
            bigEnoughIP = bigEnoughIP + "0";
        }
        ip = bigEnoughIP;
        result = testSubject.setIp(ip);
        Assert.assertEquals(true, result);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "getName", signature = "()QString;")
    @Test
    public void testGetName() throws Exception
    {
        InternetUser testSubject;
        String result;

        // default tests
        testSubject = createTestSubject();
        result = testSubject.getName();
        Assert.assertNotNull(result);
        Assert.assertEquals(true, result instanceof String);
        Assert.assertEquals(true, result.length() >= 2);
        Assert.assertEquals(true, result.length() <= MAX_NAME_LENGTH);
        String name = "Some Name";
        testSubject.setName(name);
        result = testSubject.getName();
        Assert.assertEquals(name, result);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "getIp", signature = "()QString;")
    @Test
    public void testGetIp() throws Exception
    {
        InternetUser testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getIp();
        Assert.assertEquals(DEFAULT_IP, result);
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        InternetUser testSubject;
        String result;
        String ip = "153.18.96.219";
        String name = "foothill.edu";

        // default test
        testSubject = createTestSubject();
        testSubject.setIp(ip);
        testSubject.setName(name);
        result = testSubject.toString();
        Assert.assertNotNull("toString should return an object", result);
        Assert.assertEquals(true, result instanceof String);
        Assert.assertEquals(true, result.contains(ip));
        Assert.assertEquals(true, result.contains(name));
    }
}