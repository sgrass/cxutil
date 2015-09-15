package org.cx.xml;

import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * dom写xml操作
 * @author cx
 *
 */
public class XmlWrite {

	public static void main(String[] args) {
		ResultSet rs = null;
		try {
			while (rs.next()) {
				DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
				DocumentBuilder db=dbf.newDocumentBuilder();
				Document d = db.newDocument();
				
				Element e = d.createElement("application");
				
				Element suid = d.createElement("suid");
				Text aa=d.createTextNode(rs.getString("st_wf_id"));
				suid.appendChild(aa);
				
				Element applicant_name = d.createElement("applicant_name");
				Text bb=d.createTextNode(rs.getString("st_applicant"));
				suid.appendChild(bb);			
				e.appendChild(applicant_name);
				
				Element affair_name = d.createElement("affair_name");
				Text cc=d.createTextNode(rs.getString("st_item_name"));
				suid.appendChild(cc);			
				e.appendChild(affair_name);
				
				Element department_name = d.createElement("department_name");
				Text dd=d.createTextNode(rs.getString("st_org_name"));
				suid.appendChild(dd);			
				e.appendChild(department_name);
				
				Element transact_state = d.createElement("transact_state");
				Text gg=d.createTextNode(rs.getString("st_status_name"));
				suid.appendChild(gg);			
				e.appendChild(transact_state);
				
				Element overdue_state = d.createElement("overdue_state");
				Text ii=d.createTextNode(rs.getString("st_overtime"));
				suid.appendChild(ii);			
				e.appendChild(overdue_state);
				
				d.appendChild(e);
				
				TransformerFactory tf=TransformerFactory.newInstance();
				Transformer t=tf.newTransformer();
	
				t.transform(new DOMSource(d), new StreamResult(new FileOutputStream("D:/test.xml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}







