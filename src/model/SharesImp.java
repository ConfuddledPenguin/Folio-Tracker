package model;

class SharesImp implements Shares{

	//The number of shares
	private int noShares;
	//The initial value of the shares
	private double initialValue;
	
	public SharesImp(int noShares,double initialValue){
		
		this.noShares = noShares;
		this.initialValue = initialValue;	
	}
	
	@Override
	public double getInitialValue(){
		
		return initialValue;
	}
	
	@Override
	public int getNoShares(){
		
		return noShares;
	}

	@Override
	public boolean setNoShares(int noShares) {
		
		this.noShares = noShares;
		
		return true;
	}
}
