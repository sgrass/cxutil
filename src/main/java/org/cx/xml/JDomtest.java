package org.cx.xml;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

/*
 * created on 2005-12-23
 * Intent:  JDom基本应用 
 */
public class JDomtest {

	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder sb=new SAXBuilder();
		Document d=sb.build("D:/test.xml");
		Element root=d.getRootElement();
		System.out.println(root.getChild("Name").getTextTrim());
		
		/*
		 * 使用XPath精确定位
		 */
//		SAXBuilder saxb=new SAXBuilder();
//		Document d=saxb.build("D:/mssql.xml");
//		
//		Element e=(Element) XPath.selectSingleNode(d,"//property[@name='driver']");
//		String driver=e.getAttributeValue("value");
//		System.out.println(driver);
	}
}
