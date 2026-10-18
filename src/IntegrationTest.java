
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
import static org.junit.Assert.*;

//@Generated(value = "org.junit-tools-1.0.6")
/**
 * 
 */
@SuppressWarnings("unused")
public class IntegrationTest {

//	@Generated(value = "org.junit-tools-1.0.6")
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(IntegrationTest.class.toString());
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
	public static final String defaultIntPairString = "(0, 0)";

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.setOut(out);
		System.setErr(err);
	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * 
	 */
	@Test
	public void testFullIntegration() {
		InternetUser user1 = new InternetUser(), user2 = new InternetUser("dns", "75.75.75.75"),
				user3 = new InternetUser("bad", "2.3.0.");

		Communicator giral = new Communicator(), // default
				salim = new Communicator("salim lakhani", "10.1.10.1"), // partial default
				yan = new Communicator("yan kam", "127.90.32.14", EncryptionSupport.getMedSizedRandomPrime(),
						EncryptionSupport.getMedSizedRandomPrime()), // full parameter
				sally = new Communicator("sally", "3.3.3", 19, 37), // error 1
				betty = new Communicator("betty", "1.1.1.1", 19, 100), // error 2
				colin = new Communicator("colin", "3.3.3.3", 809, 821); // colin test

		// testing base class
		System.out.println("Base Class Testing ***********************");
		System.out.println(user1 + newLine + user2.toString() + newLine + user3.toString());

		if (user3.setIp("3.3.3.3"))
			System.out.println("success as expected");
		else
			System.err.println("there's a bug in my program");
		System.out.println();

		// testing derived class constructors
		System.out.println("Derived Class Constructor Testing ***************");
		System.out.println(giral.toString() + newLine + salim + newLine + yan + newLine + sally + newLine + betty);

		// testing derived and base class mutators
		giral.setName("giral");
		giral.setPrimes(809, 821);
		salim.setPrimes(809, 809);

		System.out.println("Derived and Base Class Mutator Testing **********");
		System.out.println(giral + newLine + salim);

		// testing derived class accessor
		System.out.println("Derived Class Accessor Testing ***************");
		System.out.println(giral.getPrivateKey().toString() + newLine + giral.getPublicKey() + newLine
				+ yan.getPrivateKey().toString() + newLine + yan.getPublicKey() + newLine + newLine + ""
				+ colin.toString());
		String expected = "Base Class Testing ***********************\n" + "Name: (undefined)" + newLine
				+ "IP Address: 0.0.0.0" + newLine + newLine + newLine + "Name: dns" + newLine
				+ "IP Address: 75.75.75.75" + newLine + newLine + newLine + "Name: bad" + newLine
				+ "IP Address: 0.0.0.0" + newLine + newLine + newLine + "success as expected" + newLine + newLine
				+ "Derived Class Constructor Testing ***************" + newLine + newLine + "----------------" + newLine
				+ "Name: (undefined)" + newLine + "IP Address: 0.0.0.0" + newLine + newLine
				+ "(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0" + newLine + "public key:(0, 0)" + newLine
				+ "private key:(0, 0)" + newLine + newLine + newLine + "----------------" + newLine
				+ "Name: salim lakhani" + newLine + "IP Address: 10.1.10.1" + newLine + newLine
				+ "(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0" + newLine + "public key:(0, 0)" + newLine
				+ "private key:(0, 0)" + newLine + newLine + newLine + "----------------" + newLine + "Name: yan kam"
//              Below commented out due to random numbers
//                + newLine + "IP Address: 127.90.32.14" + newLine + newLine + "(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0"
//                + newLine + "public key:(0, 0)" + newLine + "private key:(0, 0)" + newLine + newLine + newLine
//                + "----------------" + newLine + "Name: sally" + newLine + "IP Address: 0.0.0.0" + newLine +
//                "\n" + "(p, q) n, phi, e, d: (19, 37) 703, 648, 137, 195\n" + "public key:(137, 703)\n"
//                + "private key:(195, 703)\n" + "\n" + "\n" + "----------------\n" + "Name: betty\n"
//                + "IP Address: 1.1.1.1\n" + "\n" + "(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0\n" + "public key:(0, 0)\n"
//                + "private key:(0, 0)\n" + "\n" + "Derived and Base Class Mutator Testing **********\n" + "\n"
//                + "----------------\n" + "Name: giral\n" + "IP Address: 0.0.0.0\n" + "\n"
//                + "(p, q) n, phi, e, d: (809, 821) 664189, 662560, 137, 101810\n" + "public key:(137, 664189)\n"
//                + "private key:(101810, 664189)\n" + "\n" + "\n" + "----------------\n" + "Name: salim lakhani\n"
//                + "IP Address: 10.1.10.1\n" + "\n" + "(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0\n" + "public key:(0, 0)\n"
//                + "private key:(0, 0)\n" + "\n" + "Derived Class Accessor Testing ***************\n"
//                + "(101810, 664189)\n" + "(137, 664189)\n" + "(0, 0)\n" + "(0, 0)\n" + "\n" + "\n"
//                + "----------------\n" + "Name: colin\n" + "IP Address: 3.3.3.3\n" + "\n"
//                + "(p, q) n, phi, e, d: (809, 821) 664189, 662560, 137, 101810\n" + "public key:(137, 664189)\n"
//                + "private key:(101810, 664189)\n" + "\n"
				+ "";

		Assert.assertEquals(expected, outContent.toString());
		Assert.assertTrue("The output content should start with the expected String.",
				outContent.toString().startsWith(expected));
		Assert.assertEquals("There should be no error content.", "", errContent.toString());
	}
}
