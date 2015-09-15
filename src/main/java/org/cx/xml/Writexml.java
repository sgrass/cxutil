package org.cx.xml;

/*
 * created on 2005-12-23
 * Intent:  Transformer利用写文件的方式,对已存在xml文档进行修改(适用于大型xml文档) 
 */

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
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Writexml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException, TransformerException {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document d=db.parse("D:/test.xml");
		
		Element e=d.createElement("Address");
		Text text=d.createTextNode("123123");
		e.appendChild(text);
		
		NodeList nl=d.getElementsByTagName("root");
		Element root=(Element) nl.item(0);
		root.appendChild(e);
		
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer t=tf.newTransformer();
		t.transform(new DOMSource(d),new StreamResult(new FileOutputStream("c:/copyxml.xml")));
		
	}
}
