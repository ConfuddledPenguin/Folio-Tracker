package model;

import java.util.List;

public interface Model {
	
	public Portfolio createPortfolio(String name);
	public boolean deletePortfolio(Object o);
	
	public List<Portfolio> getPortfolios();
}
