/*
 * Created on 2005-12-24 
 *本类运行需导入 jdom.jar和数据库驱动
 */
package org.cx.xml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public class JDomconn {

	public static String driver=null;
	public static String url=null;
	public static String userid=null;
	public static String password=null;
	public static String table=null;
	public static void main(String[] args) throws JDOMException, IOException, ClassNotFoundException, SQLException {
		SAXBuilder sb=new SAXBuilder();
		Document d=sb.build("d:/mssql.xml");
		
		Element dri=(Element) XPath.selectSingleNode(d,"//property[@name='driver']");
		driver=dri.getAttributeValue("value");
		
		Element ur=(Element) XPath.selectSingleNode(d,"//property[@name='url']");
		url=ur.getAttributeValue("value");
		
		Element user=(Element) XPath.selectSingleNode(d,"//property[@name='userid']");
		userid=user.getAttributeValue("value");
		
		Element pwd=(Element) XPath.selectSingleNode(d,"//property[@name='password']");
		password=pwd.getAttributeValue("value");
		
		Element tab=(Element) XPath.selectSingleNode(d,"//property[@name='table']");
		table=tab.getAttributeValue("value");
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,userid,password);
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from "+table);
		
		ResultSetMetaData rsm=rs.getMetaData();
		int  count=rsm.getColumnCount();
		
		while (rs.next()) {
			for (int i=1; i<=count; i++) {					
				System.out.print(rs.getObject(i)+"\t");
			}
			System.out.println();
		}							
	}
}



