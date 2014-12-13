package model;

public class IllegalRefreashRate extends Exception{
	
	private long minrate;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2665835288686550166L;

	public IllegalRefreashRate(String message, long rate) {
		super(message);
		this.minrate = rate;
	}
	
	public long getMinRate(){
		
		return minrate;
	}
}
