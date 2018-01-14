import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

	//private ArrayList<Rate> ratesList;
	//private StringBuffer response;

	/*XMLParser() {
		this.ratesList = new ArrayList<Rate>();
	}*/

	private static NodeList readXML() throws SAXException, ParserConfigurationException {
		String href = "http://rates.fxcm.com/RatesXML";
		URL url;
		HttpURLConnection connection = null;
		NodeList list;
		list=null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder =factory.newDocumentBuilder();
			url = new URL( href );
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty( "User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

			 Document doc=docBuilder.parse(connection.getInputStream());
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			list=doc.getElementsByTagName("Rate");
			//return list;
			/*String line;
			response = new StringBuffer();
			while( ( line = reader.readLine()) != null ) {
				response.append( line );
				response.append( '\n' );

			}*/

			//reader.close();

		} catch( MalformedURLException urlException ) {
			System.out.println( "Invalid URL" );
			System.out.println( urlException.getMessage() );
		} catch( IOException ioException ) {
			System.out.println( "Invalid Input" );
			System.out.println( ioException.getMessage() );
		}
		return list;
	}

	public static double getList(String input) throws SAXException, ParserConfigurationException {
		NodeList l=readXML();
		Update update=new Update();
		try{
			//String xmlString = this.response.toString();
			//DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			//DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			//Node document = documentBuilder.parse( new InputSource( new StringReader( xmlString ) ) );


			//NodeList nodeList = document.getChildNodes().item( 0 ).getChildNodes();

			for( int temp = 0; temp < l.getLength(); temp++ ) {
				Node node = l.item( temp );

				//System.out.println( "\nCurrent Element: " + node.getNodeName() );

				if( node.getNodeType() == Node.ELEMENT_NODE ) {
					//Rate rate = new Rate();
					Element element = (Element)node;
					update.setSymbol(element.getAttribute( "Symbol" )) ;
					update.setBid(Float.parseFloat( element.getElementsByTagName( "Bid" ).item( 0 ).getTextContent() ));
					update.setAsk(Float.parseFloat( element.getElementsByTagName( "Ask" ).item( 0 ).getTextContent() ));
					update.setHigh(Float.parseFloat( element.getElementsByTagName( "High" ).item( 0 ).getTextContent() ));
					update.setLow(Float.parseFloat( element.getElementsByTagName( "Low" ).item( 0 ).getTextContent() ));
					update.setDirection(Integer.parseInt( element.getElementsByTagName( "Direction" ).item( 0 ).getTextContent() ));
					if(update.getSymbol().toLowerCase().equals(input.toLowerCase()))
					{
						NodeList l1=element.getChildNodes();
						for(int i=0;i<l1.getLength();i++)
						{
							Node nodeNew=l1.item(i);
							if(nodeNew.getNodeType()==Node.ELEMENT_NODE)
							{
								Element elementNew=(Element)nodeNew;
								if(elementNew.getTagName()=="Bid")
								{
									return Double.parseDouble(elementNew.getTextContent());			
								}
							}
						}
					}
				}

			}

			//System.out.println( "\nRatesList Length : " + this.ratesList.size() );
		} catch( Exception e ) {
			e.printStackTrace();
			return 0;
		}
		//System.out.println( "hit" );
		return 0;


		//return ratesList;
	}

}