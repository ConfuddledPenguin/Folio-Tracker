package model;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.*;
import quoteServer.NoSuchTickerException;

public class stockTest {

	private TrackerImp tracker1;
	private Stock stock1;
	private Stock stock2;
	private Stock stock3;
	private Stock stock4;
    private static final double DELTA = 1e-15;
	@Before
	public void setUp() throws NoSuchTickerException, IOException,
			AlreadyExistsException {
		tracker1 = new TrackerImp();
		stock1 = new StockImp("ms", tracker1);
		stock2 = new StockImp("msft", tracker1);
		stock3 = new StockImp("ms", tracker1);
		stock4 = new StockImp("msft", tracker1);
		
	}

	/**
	 * Test to check that the names are returned correctly
	 */
	@Test
	public void testNames() {
		//correct ticker name
		assertEquals("ms", stock1.getTicker());
		//correct company name
		assertEquals("Morgan Stanley Co", stock1.getName());
	}

	/**
	 * Test to check that shares are added correctly
	 * 
	 * @throws CantPurchaseMoreThanAvailableException
	 */
	@Test
	public void testAddShares() throws CantPurchaseMoreThanAvailableException {
		stock1.addShares(100);
		assertEquals(100, stock1.getNumberOfShares());
		stock1.addShares(1744);
		assertEquals(1844, stock1.getNumberOfShares());
		stock1.addShares(0);
		assertEquals(1844, stock1.getNumberOfShares());
		stock1.addShares(-100);
		// negative numbers are allowed in addShares for some reason
		assertEquals(1744, stock1.getNumberOfShares());
	}
	
	/**
	 * Test that CantPurchaseMoreThanAvailableException
	 * is thrown when expected
	 * 
	 * @throws CantPurchaseMoreThanAvailableException
	 */
	@Test(expected=CantPurchaseMoreThanAvailableException.class)
	public void testCantPurchaseMoreThanAvailableException() throws CantPurchaseMoreThanAvailableException{
		double limit = stock1.getVolume();
		stock1.addShares(((int)limit)+1);
	}
	
	/**
	 * Test to check that shares are removed correctly
	 * 
	 * @throws CantPurchaseMoreThanAvailableException
	 * @throws CantRemoveMoreThanOwnedException
	 */
	@Test
	public void testRemoveShares() throws CantPurchaseMoreThanAvailableException, CantRemoveMoreThanOwnedException{
		stock1.addShares(1000);
		stock1.removeShares(500);
		assertEquals(500, stock1.getNumberOfShares());
		stock1.removeShares(26);
		assertEquals(474, stock1.getNumberOfShares());
		stock1.removeShares(0);
		assertEquals(474, stock1.getNumberOfShares());
		stock1.removeShares(-100);
		//once again allows negative numbers here
		assertEquals(574, stock1.getNumberOfShares());
	}
	
	/**
	 * test to see that CantRemoveMoreThanOwnedException is
	 * thrown when more shares are being removed than there
	 * are available
	 * 
	 * @throws CantPurchaseMoreThanAvailableException
	 * @throws CantRemoveMoreThanOwnedException
	 */
	@Test(expected=CantRemoveMoreThanOwnedException.class)
	public void testCantRemoveMoreThanOwnedException() throws CantPurchaseMoreThanAvailableException, CantRemoveMoreThanOwnedException{
		stock1.addShares(1000);
		stock1.removeShares(1100);
	}
	
	
	/**
	 * test to check that getTotalSpent works as expected
	 * 
	 * @throws CantPurchaseMoreThanAvailableException
	 */
	@Test
	public void testTotalSpent() throws CantPurchaseMoreThanAvailableException{
		stock1.addShares(1000);
		// used to find expected value
		stock3.addShares(1);
		double totalSpentExpected = stock3.getCurrentValue()*1000;
		double totalSpent = stock1.getTotalSpent();
	    assertEquals(totalSpentExpected, totalSpent, DELTA);
	    stock2.addShares(5556);
	    //used to find expected value
	    stock4.addShares(1);
	    totalSpentExpected = stock4.getCurrentValue()*5556;
	    totalSpent = stock2.getTotalSpent();
	    assertEquals(totalSpentExpected, totalSpent, DELTA);
	}
	
	/**
	 * Tests whether or not the holding value works as 
	 * expected
	 * 
	 * @throws CantPurchaseMoreThanAvailableException
	 */
	@Test
	public void testHoldingValue() throws CantPurchaseMoreThanAvailableException{
		stock1.addShares(100);
		double currentValueOfASHare = stock1.getCurrentValue();
		double expectedHoldingValue = stock1.getNumberOfShares() * currentValueOfASHare;
		assertEquals(expectedHoldingValue, stock1.getHoldingValue(),DELTA);
	}
	
	/*
	 * The rest of the StockImp class cannot really be tested since
	 * it requires knowing values which can change.
	 * 
	 * Coverage - 78.8%
	 */

}


