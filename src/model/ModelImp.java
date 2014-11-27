package model;

import java.util.ArrayList;
import java.util.List;

public class ModelImp implements Model {

	
	private List<Portfolio> portfolios;
	
	public ModelImp() {
	
		portfolios = new ArrayList<Portfolio>();
	}

	@Override
	public Portfolio createPortfolio() {
		
		Portfolio p = new PortfolioImp();
		
		portfolios.add(p);
		
		return p;
	}

	@Override
	public boolean deletePortfolio(Portfolio p) {
		
		portfolios.remove(p);
		
		return true;
	}

	@Override
	public List<Portfolio> getPortfolios() {
		
		return null;
	}
	
}
