package quoteServer;

import java.io.IOException;

/**
 * public interface that allows the setting of and retrieval of share stock values
 * 
 * @author mark meiklejohn
 *
 * @version v1 - interface added to complement <code>Quote</code> class
 *
 * All rights reserved. Copyright: 21 Nov 2008 15:06:18
 */
public interface IQuote {

	/**
	 * This method gets the web page containing the share price information and
	 * sets up the data for retrieval
	 * 
	 * @throws IOException
	 * @throws WebsiteDataException
	 * @throws NoSuchTickerException
	 * @throws MethodException
	 * 
	 * @requires: tickerSymbol != null || tickerSymbol != ""
	 * 
	 */
	public void setValues(String tickerSymbol) throws IOException, WebsiteDataException, NoSuchTickerException, MethodException;

	/**
	 * This method returns the value of the ticker
	 * 
	 * @effects String ticker: if ticker == null throws MethodException else
	 *          returns the ticker symbol for the company
	 * 
	 * @throws MethodException
	 * 
	 */
	public String getTicker() throws MethodException;

	/**
	 * This method returns the latest stock price
	 * 
	 * @effects Double latestValue: if latestValue == null throw MethodException
	 *          else return the latest stock value
	 * 
	 * @throws MethodException
	 * 
	 */
	public Double getLatest() throws MethodException;

	/**
	 * This method returns the date of the share values in format mm/dd/yy
	 * 
	 * @effects Double date: if date == null throw MethodException else returns
	 *          the date of the share values
	 * 
	 * @throws MethodException
	 * 
	 */
	public String getDate() throws MethodException;

	/**
	 * This Double returns the time of the latest share transactions in format HH:MM:AM/PM
	 * 
	 * @effects String time: if time == null throw MethodException else returns
	 *          the time of the latest share transaction
	 * 
	 * @throws MethodException
	 * 
	 */
	public String getTime() throws MethodException ;

	/**
	 * This method returns the change value of the share, if the share value has
	 * risen then it will return a value of +x.xx, however if the share value
	 * has fallen it will return -x.xx
	 * 
	 * @effects Double change: if change == null throw MethodException else
	 *          returns the change value of the share
	 * 
	 * @throws MethodException
	 * 
	 */
	public Double getChange() throws MethodException ;

	/**
	 * This method returns the days opening share prive
	 * 
	 * @effects Double open: if open == null throw MethodException else returns
	 *          the days opening share price
	 * 
	 * @throws MethodException
	 * 
	 */
	public Double getOpen() throws MethodException;
	
	/**
	 * This method returns the days range maximum value
	 * 
	 * @effects Double rangeMax: if rangeMax == null throw MethodException else
	 *          returns the days range maximum value
	 * 
	 * @throws MethodException
	 * 
	 */
	public Double getRangeMax() throws MethodException ;

	/**
	 * This method returns the days range minimum value
	 * 
	 * @effects Double rangeMin: if rangeMin == null throw Method Exception else
	 *          returns the days range minimum value
	 * 
	 * @throws MethodException
	 * 
	 */
	public Double getRangeMin() throws MethodException;

	/**
	 * This method returns the volume of shares available
	 * 
	 * @effects Double volume: if volume == null throw MethodException else
	 *          returns the volume of the shares available
	 * 
	 * @throws MethodException
	 * 
	 */
	public Double getVolume() throws MethodException;
	
	/**
	 * This method returns the name of the stock
	 * 
	 * @effects String name: if string == null throw MethodException else
	 * 			returns the name of the company.
	 * 
	 * @return The name of the company
	 * 
	 * @throws MethodException
	 */
	public String getName() throws MethodException;
	
	/**
	 * This methods returns the previous close price of the stock
	 * 
	 * @effects String close: if close == null throw MethodException else
	 *          returns the close price
	 *          
	 * @return The close price
	 * 
	 * @throws MethodException
	 */
	public Double getClose() throws MethodException;
	
	/**
	 * This methods returns the exchange the stock is listed on
	 * 
	 * @effects String exchange: if exchange == null throw MethodException else
	 *          returns the exchange the stock is listed on
	 * 
	 * @return The exchange name
	 * 
	 * @throws MethodException
	 */
	public String getExchange() throws MethodException;
	
}///:~