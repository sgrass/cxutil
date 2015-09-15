package org.cx.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * sax解析,继承DefaultHandler类
 * @author caoxiao
 * @create date 2005-12-23
 */
public class SAXxml extends DefaultHandler{

	//标签开始
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("开始标签...");
		System.out.println("uri:"+uri+"\t localName:"+localName+"\t qName:"+qName);
		for (int i=0; i<attributes.getLength(); i++) {
			System.out.println("属性名:"+attributes.getQName(i)+"="+"值:"+attributes.getValue(i));
		}
	}
	
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		System.out.println("uri:"+uri+"\t localName:"+localName+"\t name:"+name);
		System.out.println("标签结束...");
	}

	/**
	 * 标签值内容
	 * 问题：内容若含有多个回车会多次触发事件(?两个回车触发一次)
	 */
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		String text = new String(ch,start,length);
		System.out.println("文本值:"+text);
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spf=SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);  //设置支持命名空间
		spf.setValidating(true);  //设置支持验证
		
		SAXParser sp=spf.newSAXParser();		
		
		SAXxml sa=new SAXxml();
		
		sp.parse("src//test.xml",sa);		
	}
}
