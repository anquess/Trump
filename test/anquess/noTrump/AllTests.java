package anquess.noTrump;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CardTest.class,  HandTest.class, PlayerTest.class, SuitTest.class,
	DealerTest.class, TableTest.class, BidTest.class,NumberTest.class})
public class AllTests {

}
