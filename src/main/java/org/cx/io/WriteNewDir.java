package org.cx.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 根据txt文件读取所要的文件列表，并将这些文件以及目录写入新的目录中
 * @author grass
 * @create date Nov 11, 2010
 */
public class WriteNewDir {

	/**
	 * 
	 * @param readPath 需要读取文件的绝对路径
	 * @param fileList 需要读取的文件列表（txt文件,内容换行保存）
	 * 				如：bsp\js\gh_expertgs_lian_query_list.jsp
							 com.wondersgroup.jsspnet.GhApplyExchange.java
	 * @param writePath 需要写入新的目录路径
	 * @throws IOException
	 */
	public static void getFileListAndWriteNewDir(String readPath, File fileList, String writePath) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(fileList));
//		或者
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileList), "UTF-8");
//		BufferedReader read = new BufferedReader(isr);
		
		String s = null;
		String centerPath = "";
		 while((s = read.readLine())!=null){
	  	if (s.endsWith("java") || s.endsWith("class")) {
				String relativePath = s.substring(0,s.lastIndexOf(".")).replace(".", "\\");
				String fileName = relativePath.substring(relativePath.lastIndexOf("\\"))+s.substring(s.lastIndexOf("."));
				relativePath = relativePath.substring(0,relativePath.lastIndexOf("\\"));
				
				centerPath = s.endsWith("java")?"src\\":"WebRoot\\WEB-INF\\classes\\";
				String path = writePath+centerPath+relativePath;
				System.out.println(path+fileName);
				
				if (!new File(path).exists()) {
					new File(path).mkdirs();
				}
				copyFile(path+fileName, readPath+centerPath+relativePath+fileName);
			} else {
				String relativePath = s.substring(0,s.lastIndexOf("\\"));
				String fileName = s.substring(s.lastIndexOf("\\"));
				centerPath = "WebRoot\\";
					
				String path = writePath+centerPath+relativePath;
				System.out.println(path+fileName);
				
				if (!new File(path).exists()) {
					new File(path).mkdirs();
				}
				copyFile(path+fileName, readPath+centerPath+relativePath+fileName);
			}
		}
    read.close();
	}
	
	public static void copyFile(String writePath, String readPath) throws IOException {
		FileOutputStream fout = new FileOutputStream(writePath);
		FileInputStream fin = new FileInputStream(readPath);
		int len = 0;
		byte b[] = new byte[1024];
	  while ( (len = fin.read(b)) != -1) {
	  	fout.write(b, 0, len);
    }
	  fin.close();
	  fout.close();
	}
	
	public static void main(String[] args) throws IOException {
		File fileList = new File("C:\\Documents and Settings\\caoxiao\\桌面\\ttt.txt");
		String readPath = "E:\\wonders\\workspace\\TrunkShen3\\";
		String writePath = "C:\\Documents and Settings\\caoxiao\\桌面\\aa\\";
		
		getFileListAndWriteNewDir(readPath, fileList, writePath);
	}

}
