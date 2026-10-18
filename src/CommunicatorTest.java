
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

import mockit.Deencapsulation;

//@Generated(value = "org.junit-tools-1.0.6")
/**
 * 
 */
public class CommunicatorTest
{

    /**
     * 
     */
    public static final String DEFAULT_INTPAIR_STRING = "(0, 0)";
//	@Generated(value = "org.junit-tools-1.0.6")
    @SuppressWarnings("unused")
    private Logger logger = Logger.getLogger(CommunicatorTest.class.toString());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private final PrintStream err = System.err;
    /**
     * Sequence used by operating system to separate lines in text files
     */
    public static String newLine = System.getProperty("line.separator");
    /**
     * 
     */
    public final static long PRIMES[] =
    { 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
            139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251,
            257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379,
            383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
            509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
            647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787,
            797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937,
            941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061,
            1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193,
            1201, 1213, 1217, 1223 };

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

    private Communicator createTestSubject()
    {
        return new Communicator();
    }

    /**
     * Tests the specified constructors:
     * 
     * <pre>
     * Communicator()<br/>
     * Communicator( long firstPrime, long secondPrime )<br/>
     * Communicator( String name, String ip )<br/>
     * Communicator( String name, String ip, long firstPrime, long secondPrime )
     * </pre>
     * 
     * @throws Exception
     */
    @MethodRef(name = "testCommunicator", signature = "")
    @Test
    public void testCommunicator() throws Exception
    {
        Communicator testSubject;
        final String defaultName; // Assignment 4 instructions did not specify a default name
        final String DEFAULT_IP = Communicator.DEFAULT_IP;

        // test that there is a default IP as specified
        Assert.assertNotNull("There should be a default IP as specified.", DEFAULT_IP);

        // test null constructor Communicator()
        testSubject = createTestSubject();
        Assert.assertEquals("Communicator should be derived from InternetUser", true,
                testSubject instanceof InternetUser);
        defaultName = testSubject.getName();
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);

        // tests for constructor Communicator( String name, String ip )
        testSubject = new Communicator(defaultName, DEFAULT_IP);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);

        try
        {
            testSubject = new Communicator(null, null);
            Assert.fail("A NullPointerException should have been thrown because of an invalid name or an invalid IP.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
        }

        try
        {
            testSubject = new Communicator(null, "");
            Assert.fail("A NullPointerException should have been thrown because of an invalid name.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
        }

        try
        {
            testSubject = new Communicator("", null);
            Assert.fail("A NullPointerException should have been thrown because of an invalid IP.");
        } catch (NullPointerException e)
        {
            // e.printStackTrace();
        }

        testSubject = new Communicator("", "");
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);

        // test constructor Communicator( long firstPrime, long secondPrime )
        long p = PRIMES[PRIMES.length - 1];
        long q = PRIMES[PRIMES.length - 2];
        testSubject = new Communicator(p, q);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);
        checkPrimes(testSubject, p, q);
        p = 360;
        q = 36;
        testSubject = new Communicator(p, q);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);
        checkNotPrimes(testSubject);

        // test constructor Communicator( String name, String ip, long firstPrime, long
        // secondPrime )
        p = PRIMES[PRIMES.length - 3];
        q = PRIMES[PRIMES.length - 4];
        testSubject = new Communicator("", "", p, q);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);
        checkPrimes(testSubject, p, q);
        p = 36;
        q = 360;
        testSubject = new Communicator("", "", p, q);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);
        checkNotPrimes(testSubject);

        // Make sure primes can't be too large
        final long MAX_PQ = (long) Math.sqrt(Long.MAX_VALUE);
        p = PRIMES[PRIMES.length - 5];
        q = PRIMES[PRIMES.length - 6];
        testSubject = new Communicator(MAX_PQ + 1, q);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);
        checkNotPrimes(testSubject);
        testSubject = new Communicator(p, MAX_PQ + 1);
        checkInternetUserDefaults(testSubject, defaultName, DEFAULT_IP);
        checkNotPrimes(testSubject);
    }

    /**
     * @param testSubject
     * @param p
     * @param q
     */
    void checkPrimes(Communicator testSubject, long p, long q)
    {
        long firstPrime = Deencapsulation.getField(testSubject, "firstPrime");
        Assert.assertNotNull(firstPrime);
        Assert.assertEquals(p, firstPrime);
        long secondPrime = Deencapsulation.getField(testSubject, "secondPrime");
        Assert.assertNotNull(secondPrime);
        Assert.assertEquals(q, secondPrime);
    }

    /**
     * @param testSubject
     * @param p
     * @param q
     */
    void checkNotPrimes(Communicator testSubject)
    {
        long firstPrime = Deencapsulation.getField(testSubject, "firstPrime");
        Assert.assertNotNull(firstPrime);
        Assert.assertEquals(Communicator.ERROR_FLAG_NUM, firstPrime);
        long secondPrime = Deencapsulation.getField(testSubject, "secondPrime");
        Assert.assertNotNull(secondPrime);
        Assert.assertEquals(Communicator.ERROR_FLAG_NUM, secondPrime);
    }

    /**
     * @param testSubject
     * @param defaultName
     * @param DEFAULT_IP
     */
    void checkInternetUserDefaults(Communicator testSubject, final String defaultName, final String DEFAULT_IP)
    {
        String actualDefaultName;
        String actualDefaultIP;

        if (defaultName.equals(DEFAULT_IP))
        {
            Assert.fail("The defaultName should not equal the DEFAULT_IP.");
        }

        actualDefaultIP = testSubject.getIp();
        Assert.assertNotNull(actualDefaultIP);
        Assert.assertEquals(true, actualDefaultIP instanceof String);

        actualDefaultName = testSubject.getName();
        Assert.assertNotNull(actualDefaultName);
        Assert.assertEquals(true, actualDefaultName instanceof String);
        Assert.assertEquals(true, actualDefaultName.length() >= 2);
        Assert.assertEquals(true, actualDefaultName.length() <= Communicator.MAX_NAME_LENGTH);

        if (!DEFAULT_IP.equals(actualDefaultIP))
        {
            // Constructor may have been implemented with IP parameter first and name
            // parameter second
            if (!defaultName.equals(actualDefaultIP))
            {
                Assert.fail("The actualDefaultIP:" + actualDefaultIP + " was not correct.");
            }
        }
        if (!defaultName.equals(actualDefaultName))
        {
            // Constructor may have been implemented with IP parameter first and name
            // parameter second
            if (!DEFAULT_IP.equals(actualDefaultName))
            {
                Assert.fail("The actualDefaultName:" + actualDefaultName + " was not correct.");
            }
        }
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "getPublicKey", signature = "()QIntPair;")
    @Test
    public void testGetPublicKey() throws Exception
    {
        Communicator testSubject;
        IntPair result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getPublicKey();
        Assert.assertNotNull(result);
        Assert.assertEquals(CommunicatorTest.DEFAULT_INTPAIR_STRING, result.toString());
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "getPrivateKey", signature = "()QIntPair;")
    @Test
    public void testGetPrivateKey() throws Exception
    {
        Communicator testSubject;
        IntPair result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getPrivateKey();
        Assert.assertNotNull(result);
        Assert.assertEquals(CommunicatorTest.DEFAULT_INTPAIR_STRING, result.toString());
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        Communicator testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.toString();
        Assert.assertNotNull(result);
        Assert.assertEquals("Communicator.toString():'" + result + "' should contain Communicator.DEFAULT_IP:'"
                + Communicator.DEFAULT_IP + "' but it does NOT!", true, result.contains(Communicator.DEFAULT_IP));
        Assert.assertEquals(
                "Communicator.toString():'" + result + "' should contain the default IntPair String:'"
                        + CommunicatorTest.DEFAULT_INTPAIR_STRING + "' but it does NOT!",
                true, result.contains(CommunicatorTest.DEFAULT_INTPAIR_STRING));
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "computeBothEncrKeys", signature = "()Z")
    @Test
    public void testComputeBothEncrKeys() throws Exception
    {
        Communicator testSubject;
        boolean result = false;

        // test primes
        final int MAX_ROUNDS = 1000;// Integer.MAX_VALUE;
        for (int round = 0; round < MAX_ROUNDS; ++round)
        {
            for (int pIndex = 0; pIndex < PRIMES.length - 1; ++pIndex)
            {
                testSubject = new Communicator(PRIMES[pIndex], PRIMES[pIndex + 1]);
                long e = Deencapsulation.getField(testSubject, "e");
                long phi = Deencapsulation.getField(testSubject, "phi");
                Assert.assertNotNull(e);
                Assert.assertNotNull(phi);
                Assert.assertEquals("e:" + e + " >= phi:" + phi + " when PRIMES[pIndex]:" + PRIMES[pIndex]
                        + " , PRIMES[pIndex + 1]:" + PRIMES[pIndex + 1], true, e < phi);
                try
                {
                    Assert.assertEquals("phi:" + phi + " % e:" + e + " is:" + (phi % e) + " when PRIMES[pIndex]:"
                            + PRIMES[pIndex] + " , PRIMES[pIndex + 1]:" + PRIMES[pIndex + 1], true, phi % e != 0);
                } catch (Exception e1)
                {
                    Assert.fail(e1.getLocalizedMessage() + newLine + "phi:" + phi + " e:" + e + " when PRIMES[pIndex]:"
                            + PRIMES[pIndex] + " , PRIMES[pIndex + 1]:" + PRIMES[pIndex + 1]);
                }
                IntPair publicKey = testSubject.getPublicKey();
                Assert.assertNotNull(publicKey);
//			Assert.assertEquals("", publicKey.toString());
                Assert.assertNotEquals(
                        "PRIMES[pIndex]:" + PRIMES[pIndex] + " publicKey.toString():" + publicKey.toString(),
                        Communicator.ERROR_FLAG_NUM, publicKey.firstInt);
                Assert.assertNotEquals(
                        "PRIMES[pIndex + 1]:" + PRIMES[pIndex + 1] + " publicKey.toString():" + publicKey.toString(),
                        Communicator.ERROR_FLAG_NUM, publicKey.secondInt);
                Assert.assertNotEquals(Communicator.ERROR_FLAG_NUM, publicKey);
                IntPair privateKey = testSubject.getPrivateKey();
                Assert.assertNotNull(privateKey);
                // Assert.assertEquals("", privateKey.toString());
                Assert.assertNotEquals(
                        "PRIMES[pIndex]:" + PRIMES[pIndex] + " privateKey.toString():" + privateKey.toString(),
                        Communicator.ERROR_FLAG_NUM, privateKey.firstInt);
                Assert.assertNotEquals("PRIMES[pIndex + 1]:" + PRIMES[pIndex + 1] + " publprivateKeyicKey.toString():"
                        + privateKey.toString(), Communicator.ERROR_FLAG_NUM, privateKey.secondInt);
            }
        }

        // default test
        testSubject = createTestSubject();
        try
        {
            result = Deencapsulation.invoke(testSubject, "computeBothEncrKeys");
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
            // testSubject.computeBothEncrKeys(testSubject.firstPrime,
            // testSubject.secondPrime);
        }
        Assert.assertEquals(false, result);
    }
}