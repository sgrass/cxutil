/*
 * Created on 2005-12-24
 */
package org.cx.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class NewWrite {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException, TransformerException {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document d=db.newDocument();
				
		Element e=d.createElement("root");		
		for (int i=0; i<10000; i++) {
			Element  address=d.createElement("address");
			address.setAttribute("addres","九龙");
			Text resstext=d.createTextNode("港台");
			address.appendChild(resstext);			
			e.appendChild(address);
			
			Element  song=d.createElement("SongName");
			song.setAttribute("name","陈慧琳");
			Text text=d.createTextNode("穿越时空遇见你");
			song.appendChild(text);			
			e.appendChild(song);			
		}
		d.appendChild(e);
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer t=tf.newTransformer();
		
		t.transform(new DOMSource(d), new StreamResult(new FileOutputStream("C:/test.xml")));
	}
}
