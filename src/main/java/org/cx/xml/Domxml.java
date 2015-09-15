package org.cx.xml;

/*
 * created on 2005-12-23
 * Intent:  dom解析xml文档连接数据库
 * 另:(本类运行需数据库驱动)
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Domxml {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document d=db.parse("E:\\mssql.xml");
		
		NodeList nl=d.getElementsByTagName("property");		
		String[] s=new String[nl.getLength()];
		for (int i=0; i<nl.getLength(); i++) {
			Element e=(Element) nl.item(i);			
			s[i]=e.getAttribute("value");			
		}		
		
		Class.forName(s[0]);
		Connection conn=DriverManager.getConnection(s[1],s[2],s[3]);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from "+s[4]);
		while (rs.next()) {
			System.out.println(rs.getObject(1));
		}
		stmt.close();
		conn.close();
	}
}
