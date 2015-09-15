package org.cx.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerTest {

	/**
	 * 按行读取文件
	 */
	public static void getTxtContent() {
		try {
			Scanner sn = new Scanner(new File("C:\\Documents and Settings\\caoxiao\\桌面\\ttt.txt"));
			
			//根据正则表达式来读取
			sn.useDelimiter("\\n");
			
			while (sn.hasNext()) {
				System.out.print(sn.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 过滤传入的字符串,只保留大小写字母和下划线
	 * @param str
	 * @return
	 */
	public static String filterString(String str) {
		String regEx = "[^a-zA-Z_]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}
	
	/**
	 * 按行读取文件存入list然后比较list
	 */
	public static void compareList() {
		try {
			List<String> aa = new ArrayList<String>();
			List<String> bb = new ArrayList<String>();
			//按照utf-8的字符编码的格式进行扫描处理，若该文件的编码不是utf-8的编码方式则扫描出来的结果将0,也就是扫描不出来  
			Scanner at = new Scanner(new File("C:\\Documents and Settings\\caoxiao\\桌面\\aa.txt"),"UTF-8");
			Scanner bt = new Scanner(new File("C:\\Documents and Settings\\caoxiao\\桌面\\bb.txt"));
//			at.useDelimiter("\\n");
//			bt.useDelimiter("\\n");
			while (at.hasNext()) {
				aa.add(at.next().trim());
			}
			while (bt.hasNext()) {
				bb.add(bt.next().trim());
			}
			
			
			//aa中的值不存在于bb
			for (String str:aa) {
				if (!bb.contains(str)) {
					System.out.println(str);
				}
			}
			
			//bb中的值不存在于aa
			for (String str:bb) {
				if (!aa.contains(str)) {
					System.out.println(str);
				}
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		compareList();
	}
}
