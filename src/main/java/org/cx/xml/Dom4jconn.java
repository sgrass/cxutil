/*
 * Created on 2005-11-19
 *
 * 本类运行需要 以下类库支持:dom4j.jar , jaxen-1.1-beta-4.jar , 数据库驱动
 */
package org.cx.xml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author cx
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Dom4jconn {

	public static void main(String[] args) throws DocumentException, ClassNotFoundException, SQLException {
		
		SAXReader parse=new SAXReader();
		
		Document doc = parse.read("database.xml");
		/**
		 * 取驱动字符串
		 */
		Element d =(Element) doc.selectSingleNode("//property[@name='driver']");
		
		String driver = d.attribute("value").getText();
		/**
		 * 取连接字符串
		 */
		Element u =(Element) doc.selectSingleNode("//property[@name='url']");
		
		String url = u.attribute("value").getText();
		/**
		 * 取数据库用户名
		 */
		Element usr =(Element) doc.selectSingleNode("//property[@name='username']");
		
		String user = usr.attribute("value").getText();
		/**
		 * 取数据库密码
		 */
		Element pass =(Element) doc.selectSingleNode("//property[@name='password']");
		
		String password = pass.attribute("value").getText();
		/**
		 * 取访问表名
		 */
		Element t =(Element) doc.selectSingleNode("//property[@name='table']");
		
		String table = t.attribute("value").getText();
		
		/**
		 * 开始JDBC操作
		 */
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,user,password);
		/**
		 * 构建能支持游标动态滚动的statement
		 * 支持绝对定位游标位置，以及非单向单步滚动
		 */
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
											ResultSet.CONCUR_UPDATABLE);
		
		/*******ResultSetMetaData 可以取出某张表的整个记录*******/
		ResultSet rs = stmt.executeQuery("select * from "+table);
		
		while(rs.next())
		{
			/**
			 * 取当前记录第一列的值
			 */
			System.out.println(rs.getObject(1));
		}
		
		stmt.close();
		
		conn.close();
		
	}
}
