import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.engine.discovery.DiscoverySelectors;

import java.io.PrintWriter;

import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request;

/**
 * You must submit code that passes all the unit tests (except
 * testFullIntegration) in order to get more than a grade of zero. Running the
 * test suite could take around 30 seconds or so. The testFullIntegration output
 * should match until the random communicator outputs begin, but because the
 * actual output will be random testFullIntegration will never pass and that is
 * expected.
 * 
 * @author Baba Kofi Weusijana
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
//	IntegrationStackTest.class, IuNodeTest.class, IuStackTest.class, // Option B tests
	IntPairTest.class, InternetUserTest.class, CommunicatorTest.class, IntegrationTest.class })
public class TestSuite {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a Launcher to execute tests
		// Listener to generate test execution summary
		SummaryGeneratingListener listener = null;
		try {
			Launcher launcher = LauncherFactory.create();

			listener = new SummaryGeneratingListener();

			// Create a request to select all test classes
			LauncherDiscoveryRequest request = request()
					// Option B tests
//					.selectors(DiscoverySelectors.selectClass(IntegrationStackTest.class))
//					.selectors(DiscoverySelectors.selectClass(IuNodeTest.class))
//					.selectors(DiscoverySelectors.selectClass(IuStackTest.class))
					// Option A & B tests
					.selectors(DiscoverySelectors.selectClass(IntPairTest.class))
					.selectors(DiscoverySelectors.selectClass(InternetUserTest.class))
					.selectors(DiscoverySelectors.selectClass(CommunicatorTest.class))
					.selectors(DiscoverySelectors.selectClass(IntegrationTest.class)).build();

			// Execute the tests
			launcher.execute(request, listener);
		} catch (PreconditionViolationException e) {
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

		// Print the test results summary to the console
		try (PrintWriter writer = new PrintWriter(System.out)) {
			listener.getSummary().printTo(writer);
		} catch (Exception e) {
			if (e != null && System.err != null) {
				try {
					System.err.println(e.getLocalizedMessage());
					System.err.println(e.getStackTrace());
				} catch (Exception e1) {
//					System.err.println(e1.getLocalizedMessage());
//					e1.printStackTrace();
				}
			}
		}
		// Print the test failures to the error console
		try (PrintWriter errWriter = new PrintWriter(System.err)) {
			listener.getSummary().printFailuresTo(errWriter);
		} catch (Exception e) {
			if (e != null && System.err != null) {
				System.err.println(e.getLocalizedMessage());
				System.err.println(e.getStackTrace());
			}
		}
	}
}
