package model;

/**
 * This is used to represnt an illegal refreash rate request
 * 
 * @author Tom
 *
 */
public class IllegalRefreashRateException extends Exception{
	
	private long minrate;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2665835288686550166L;

	/**
	 * The constructor
	 * 
	 * @param message A message
	 * @param rate the minimum valid rate
	 */
	public IllegalRefreashRateException(String message, long rate) {
		super(message);
		this.minrate = rate;
	}
	
	/**
	 * Returns the minimum valid rate
	 * 
	 * @effects returns this.minRate;
	 * 
	 * @return the rate
	 */
	public long getMinRate(){
		
		return minrate;
	}
}
