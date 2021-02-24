package calculadoraTestSuite;

import calculadoraTest.SumaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(
        {
                SumaTest.class
        }
)


public class TestSuiteCalculadora {
}
