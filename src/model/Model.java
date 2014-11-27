package model;

import java.util.List;

public interface Model {
	
	public Portfolio createPortfolio();
	public boolean deletePortfolio(Portfolio p);
	
	public List<Portfolio> getPortfolios();
}
