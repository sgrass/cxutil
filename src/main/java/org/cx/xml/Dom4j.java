package org.cx.xml;

/*
 * created on 2005-12-23
 * Intent:  dom4j基本应用
 * 另:(本类运行需导入dom4j-1.5.2.zip工具中 dom4j-1.5.2.jar与jaxen-1.1-beta-4.jar文件)
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j {

	public static void main(String[] args) throws DocumentException {		
//      SAXReader read=new SAXReader();
//      Document d=read.read("D:/test.xml");
//      Element root=d.getRootElement();                
//      System.out.println(root.element("content").getTextTrim());

		/*
		 * 使用XPath精确定位
		 */
		SAXReader read=new SAXReader();
		Document d=read.read("D:/mssql.xml");
		
		Element root=(Element) d.selectSingleNode("//property[@name='url']");
		String url=root.attribute("value").getText();
		System.out.println(url);
	}
}
