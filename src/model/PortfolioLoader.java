package model;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The class handles the loading of portfolios
 * 
 * @author Tom
 *
 */
class PortfolioLoader {

	private TrackerImp tracker;
	
	/**
	 * The default constructor
	 * 
	 * @param tracker
	 */
	PortfolioLoader(TrackerImp tracker) {
		
		this.tracker = tracker;
	}
	
	/**
	 * Loads the given file/portfolio
	 * 
	 * @effects loads and add the portfolio into the model
	 * @modifies this, tracker
	 * 
	 * @param inputFile The file to be loaded
	 * @return the loaded portfolio
	 * @throws FailedToLoadFileException 
	 */
	Portfolio loadPortfolio(File inputFile) throws FailedToLoadFileException{
		 
		PortfolioImp portfolio = null;
		
		try{
			
			DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFac.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			
			//Quick sanity formating. Should be fine unless someone has been playing with the file . . .
			doc.getDocumentElement().normalize();
			
			NodeList nl = doc.getElementsByTagName("portfolio");
			
			if(nl.getLength() == 1){
				Node n = nl.item(0);
				
				if(n.getNodeType() == Node.ELEMENT_NODE){
					Element e = (Element) n;
					
					portfolio = (PortfolioImp) tracker.createPortfolio(e.getAttribute("name"));
				}
			}else{
				throw new InputFileFormattedIncorrectlyException("Contains more than one portfolio");
			}
			
			nl = doc.getElementsByTagName("stock");
			
			for (int i = 0; i < nl.getLength(); i++){
				
				Node n = nl.item(i);
				
				if( n.getNodeType() == Node.ELEMENT_NODE){
					
					Element e = (Element) n;
					
					System.out.println(e.getElementsByTagName("ticker").item(0).getTextContent());
					StockImp s = (StockImp) portfolio.newStock(e.getElementsByTagName("ticker").item(0).getTextContent());
					s.setNoShares(Integer.parseInt(e.getElementsByTagName("noShares").item(0).getTextContent()));
					s.setTotalSpent(Double.parseDouble(e.getElementsByTagName("totalSpent").item(0).getTextContent()));
				}
			}
			
		}catch(Exception e){
			throw new FailedToLoadFileException();
		}
		
		return portfolio;
	}
}
