package org.cx.xml;

/*
 * create on 2005-12-22
 * Intent: 把xml文档中的数据写入数据库(很少这样做,没意义)
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlWriteDb {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");		
		Connection conn = DriverManager.getConnection(
				"jdbc:jtds:sqlserver://localhost:1433/pubs","sa","sa");
		
		PreparedStatement stmt = conn.prepareStatement(
				"insert into test values(?,?)");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db =dbf.newDocumentBuilder();		
		Document d = db.parse("c:/test.xml");	
		
		NodeList nl = d.getElementsByTagName("root");		
		for(int i=0;i<nl.getLength();i++) {
			Element test = (Element) nl.item(i);
			
			String id = test.getChildNodes().item(1).getFirstChild().getNodeValue();			
			String name = test.getChildNodes().item(3).getFirstChild().getNodeValue();
			
			stmt.setInt(1,Integer.parseInt(id));			
			stmt.setString(2,name);			
			stmt.execute();			
		}		
		stmt.close();		
		conn.close();		
	}
}





