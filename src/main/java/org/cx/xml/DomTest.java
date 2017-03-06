package org.cx.xml;

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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DomTest {

	public static void printNote(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("<" + node.getNodeName() + ">");
				System.out.println(node.getTextContent());
				if (node.hasAttributes()) {
					NamedNodeMap nodeMap = node.getAttributes();
					for (int j = 0; j < nodeMap.getLength(); j++) {
						Node nd = nodeMap.item(j);
						System.out.println(nd.getNodeName() + "=" + nd.getNodeValue());
					}
				}
				if (node.hasChildNodes()) {
					printNote(node.getChildNodes());
				}
				System.out.println("<" + node.getNodeName() + "/>");
			}
		}
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document d = db.parse("src/main/java/org/cx/xml/student.xml");
		Document d = db.newDocument();

//		NodeList nodeList = d.getChildNodes();
//		 printNote(nodeList);
//		
		NodeList nodeList = d.getElementsByTagName("student");
		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Element e = (Element) nodeList.item(temp);
			NodeList nl = e.getElementsByTagName("name");
			
			for (int i=0; i<nl.getLength(); i++) {
				Element elem = (Element) nl.item(i);
				System.out.println(elem.getTagName());
				System.out.println(elem.getAttribute("type"));
				System.out.println(elem.getTextContent());
			}
			
		}
		
		
//		Element e = d.createElement("application");
//		
//		Element suid = d.createElement("suid");
//		Text aa=d.createTextNode("aaa");
//		suid.appendChild(aa);
//		e.appendChild(suid);
//		
//		Element applicant_name = d.createElement("applicant_name");
//		Text bb=d.createTextNode("bb");
//		applicant_name.appendChild(bb);
//		applicant_name.setAttribute("type", "int");
//		e.appendChild(applicant_name);
//		
//		
//		d.appendChild(e);
//		TransformerFactory tf=TransformerFactory.newInstance();
//		Transformer t=tf.newTransformer();
//
//		t.transform(new DOMSource(d), new StreamResult(new FileOutputStream("src/main/java/org/cx/xml/test.xml")));
	}

}
