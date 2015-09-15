package org.cx.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 读取xml
 * @author cx
 * @create date 2011-5-10
 */
public class XmlRead {
	
	public static void xmlReadByDom() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("file:/C:/Documents and Settings/caoxiao/桌面/build-jar.xml");
			NodeList nl = XPathAPI.selectNodeList(d, "//project/property[@name='classes.dir']");
			for (int i=0; i<nl.getLength(); i++) {
				Element ele = (Element) nl.item(i);
				System.out.println(ele.getAttribute("value"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		xmlReadByDom();
	}

}
