package model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import quoteServer.NoSuchTickerException;

public class PortfolioTest {

	private TrackerImp tracker1;
	private Portfolio portfolio1;
	private Stock stock1;
	private Stock stock2;
    
	//variable to allow error in double calculation
	private static final double DELTA = 1.0;

	@Before
	public void setUp() throws NoSuchTickerException, IOException,
			AlreadyExistsException, CantPurchaseMoreThanAvailableException {
		tracker1 = new TrackerImp();
		portfolio1 = new PortfolioImp("Portfolio1", tracker1);
		stock1 = new StockImp("AAPL", tracker1);
		stock1.addShares(1);
		stock2 = new StockImp("ms", tracker1);
		stock2.addShares(1);

	}

	/**
	 * Test to check that adding a stock to a portfolio works correctly
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 */
	@Test
	public void testAddingStock() throws NoSuchTickerException, IOException,
			AlreadyExistsException {
		portfolio1.newStock("ms");
		List<Stock> stocks = new ArrayList<Stock>();
		stocks = portfolio1.getStocks();
		assertEquals(stocks.get(0).getTicker(), "MS");
	}

	/**
	 * Test NoSuchTickerException is thrown when user enters incorrect ticker
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 */
	@Test(expected = NoSuchTickerException.class)
	public void testNoSuchTickerException() throws NoSuchTickerException,
			IOException, AlreadyExistsException {
		portfolio1.newStock("aaaaaa");
	}

	/**
	 * Test AlreadyExistsException is thrown when the user tries to enter a
	 * ticker that already exists
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 */
	@Test(expected = AlreadyExistsException.class)
	public void testAlreadyExistsException() throws NoSuchTickerException,
			IOException, AlreadyExistsException {
		portfolio1.newStock("ms");
		portfolio1.newStock("ms");
	}

	/**
	 * Test to show deleteStock() works as intended
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 */
	@Test
	public void testDeletingStock() throws NoSuchTickerException, IOException,
			AlreadyExistsException {
		portfolio1.newStock("ms");
		portfolio1.newStock("msft");
		List<Stock> stocks = portfolio1.getStocks();
		assertTrue(portfolio1.deleteStock(stocks.get(0)));
		assertFalse(portfolio1.deleteStock(null));
	}

	/**
	 * Test to check that totalValue works as expected. 
	 * Also tests if it works when a stock is removed
	 * or shares are sold
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 * @throws CantPurchaseMoreThanAvailableException
	 * @throws CantRemoveMoreThanOwnedException 
	 */
	@Test
	public void testTotalValue() throws NoSuchTickerException, IOException,
			AlreadyExistsException, CantPurchaseMoreThanAvailableException, CantRemoveMoreThanOwnedException {
		portfolio1.newStock("AAPL");
		portfolio1.newStock("ms");
		List<Stock> stocks = portfolio1.getStocks();
		stocks.get(0).addShares(1000);
		stocks.get(1).addShares(1000);
		//values of 1 share
		double stock1Value = stock1.getCurrentValue();
		double stock2Value = stock2.getCurrentValue();
		double expectedTotalValue = (stock1Value * 1000) + (stock2Value * 1000);
		assertEquals(portfolio1.getTotalValue(), expectedTotalValue, DELTA);
		// test when shares are removed 
		stocks.get(1).removeShares(10);
		expectedTotalValue = (stock1Value * 1000) + (stock2Value * 990);
		assertEquals(portfolio1.getTotalValue(), expectedTotalValue, DELTA);
		//test when a stock is removed
		portfolio1.deleteStock(stocks.get(1));
		expectedTotalValue = (stock1Value * 1000);
		assertEquals(portfolio1.getTotalValue(), expectedTotalValue, DELTA);
		
	}
	
	/**
	 * Test to show saving the portfolio works
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 * @throws CantPurchaseMoreThanAvailableException
	 * @throws FailedToSaveFileException
	 * @throws FailedToLoadFileException 
	 */
	@Test
	public void testSavePortfolio() throws NoSuchTickerException, IOException, AlreadyExistsException, CantPurchaseMoreThanAvailableException, FailedToSaveFileException, FailedToLoadFileException{
		portfolio1.newStock("ms");
		List<Stock> stocks = portfolio1.getStocks();
		stocks.get(0).addShares(1000);
		File test = new File("test.ftf");
		portfolio1.savePortfolio(test);
		tracker1.deletePortfolio(portfolio1);
	    tracker1.loadPortfolio(test);
	    //check to see if the portfolio is the same
	    stocks = portfolio1.getStocks();
	    assertEquals("MS", stocks.get(0).getTicker());
	    assertEquals(1, portfolio1.getStocks().size());
	}
	
	/**
	 * Test to check whether FailedToLoadFileException 
	 * is thrown correctly
	 * @throws FailedToLoadFileException
	 */
	@Test(expected=FailedToLoadFileException.class)
	public void testFailedToLoadFileException() throws FailedToLoadFileException {
		File test = new File("fail.tft");
		tracker1.loadPortfolio(test);
	}
	
	/**
	 * Test to check whether FailedToSaveFileException
	 * is thrown correctly
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 * @throws CantPurchaseMoreThanAvailableException
	 * @throws FailedToSaveFileException
	 */
	@Test(expected=FailedToSaveFileException.class)
	public void testFailedToSaveFileException() throws NoSuchTickerException, IOException, AlreadyExistsException, CantPurchaseMoreThanAvailableException, FailedToSaveFileException{
		portfolio1.newStock("ms");
		List<Stock> stocks = portfolio1.getStocks();
		stocks.get(0).addShares(1000);
		File test = new File("/fail");
		portfolio1.savePortfolio(test);
	}
	
	/**
	 * Test to check that noOfStocks works as expected
	 * 
	 * @throws NoSuchTickerException
	 * @throws IOException
	 * @throws AlreadyExistsException
	 */
	@Test
	public void testNoOfStocks() throws NoSuchTickerException, IOException, AlreadyExistsException{
		PortfolioImp portfolio3 = new PortfolioImp("3", tracker1);
		portfolio3.newStock("ms");
		portfolio3.newStock("MSFT");
		assertEquals(2, portfolio3.noStocks());
		portfolio3.newStock("AAPL");
		assertEquals(3, portfolio3.noStocks());
		List<Stock> stocks = portfolio3.getStocks();
		portfolio3.deleteStock(stocks.get(0));
		assertEquals(2, portfolio3.noStocks());
	}
}
	
	/*
	 * Test coverage of PortfolioImp is 70.7%
	 * getNetGain can't really be tested since 
	 * it requires values which will change
	 * 
	 */
	
