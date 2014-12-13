package model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

class PortfolioSaver {
	
	void savePortfolio(PortfolioImp portfolio, File outputFile){
		
		if (!outputFile.exists()) {
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
		
			//create tools
			DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFac.newDocumentBuilder();
			
			//create doc
			Document doc = docBuilder.newDocument();
			
			//root
			Element rootElem = doc.createElement("portfolio");
			doc.appendChild(rootElem);
			rootElem.setAttribute("name", portfolio.getName());
			
		
			//Add Stock info
			for(Stock s: portfolio.getStocks()){
				
				Element stock = doc.createElement("stock");
				rootElem.appendChild(stock);
				
				Element ticker = doc.createElement("ticker");
				ticker.appendChild(doc.createTextNode(s.getTicker()));
				stock.appendChild(ticker);
				
				Element noShares = doc.createElement("noShares");
				noShares.appendChild(doc.createTextNode(String.valueOf(s.getNumberOfShares())));
				stock.appendChild(noShares);
				
				Element totalSpent = doc.createElement("totalSpent");
				totalSpent.appendChild(doc.createTextNode(String.valueOf(s.getTotalSpent())));
				stock.appendChild(totalSpent);
			}
			
			//write file
			TransformerFactory tranFact = TransformerFactory.newInstance();
			Transformer transformer = tranFact.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(outputFile);
			transformer.transform(source, result);
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(TransformerConfigurationException e){
			e.printStackTrace();
		}catch(TransformerException e){
			e.printStackTrace();
		}
		
		System.out.println("saved");
	}
}
