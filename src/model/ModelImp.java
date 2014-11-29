package model;

import java.util.ArrayList;
import java.util.List;

public class ModelImp implements Model {

	
	private List<Portfolio> portfolios;
	
	public ModelImp() {
	
		portfolios = new ArrayList<Portfolio>();
	}

	@Override
	public Portfolio createPortfolio(String name) {
		
		Portfolio p = new PortfolioImp(name);
		
		portfolios.add(p);
		
		return p;
	}

	@Override
	public boolean deletePortfolio(Object o) {
		
		if ( o instanceof Portfolio){
		
			portfolios.remove( (Portfolio) o);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Portfolio> getPortfolios() {
		
		return new ArrayList<Portfolio>(portfolios);
	}
	
}
