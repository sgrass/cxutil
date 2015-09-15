package org.cx.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 根据jboss临时目录中的jsp生成的java文件，从部署目录中提取jsp文件并写入某个位置
 * @author grass
 * @Created on 2009-09-29
 */
public class Test {

	public void getNextFile(File file) throws IOException {
		File flist[] = file.listFiles();
		for (int i=0; i<flist.length; i++) {
			//判断文件是否是目录
			if (flist[i].isDirectory()) {
				this.getNextFile(flist[i]);
			} else {
				//不是目录的话
				int flen = flist[i].getName().lastIndexOf(".");
				String extendName = null;
				if (flen > 0) 
					 extendName = flist[i].getName().substring(flen+1, flist[i].getName().length());
				//判断扩展名为java的
				if ("java".equals(extendName)) {
					//获取文件目录路径(不含文件名)
					String fdir = flist[i].getParentFile().toString();
					String fileName = flist[i].getName();
					int fl = fileName.lastIndexOf("_");
					fileName = fileName.substring(0,fl);
					fileName = fileName.replaceAll("005f", "");
					//部署目录路径
					String path = "D:/jboss-4.2.2.GA/server/default/deploy/gsspnet.war";
					String tpath[] = fdir.split("jsp", fdir.length());
					File fr = new File(path+tpath[1]+"/"+fileName+".jsp");
					FileInputStream fin = new FileInputStream(fr);
					//文件写入的路径
					File fw = new File("D:/aa/"+tpath[1]);
					//创建目录
					fw.mkdirs();
					FileOutputStream fout = new FileOutputStream("D:/aa/"+tpath[1]+"/"+fileName+".jsp");
					byte b[] = new byte[(int) fr.length()];
					System.out.println(fileName+".jsp");
					for (int j=0; j<fr.length(); j++) {
						b[i] = (byte) fin.read();
						fout.write(b[i]);
					}
				}
			}
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("D:/jboss-4.2.2.GA/server/default/work/jboss.web/localhost/gsspnet/");
		Test t = new Test();
		t.getNextFile(file);
		
	}

}
