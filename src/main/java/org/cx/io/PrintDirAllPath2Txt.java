package org.cx.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 输出目录所有文件路径和大小
 * @author grass
 * @create date Sep 19, 2010
 */
public class PrintDirAllPath2Txt {

	
	public void getAllFileList(File file) {
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Documents and Settings\\caoxiao\\桌面\\filelist.txt",true);
			File flist[] = file.listFiles();
			for (int i=0; i<flist.length; i++) {
				if (flist[i].isDirectory()) {
					this.getAllFileList(flist[i]);
				} else {
					String path = flist[i].getPath().replace(
							"D:\\jboss-4.2.2.GA\\server\\default\\deploy\\shen3spnet.war", "")+"\t"+flist[i].length()+"\n";
					fout.write(path.getBytes());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void test(File proFile, File devFile) {
		File proFileList[] = proFile.listFiles();
		File devFileList[] = devFile.listFiles();
		
		for (int i=0; i<proFileList.length; i++) {
			for (int j=0; j<devFileList.length; j++) {
				
			}
		}
	}
	
	public static void main(String[] args) {
//		File file = new File("D:\\jboss-4.2.2.GA\\server\\default\\deploy\\shen3spnet.war");
//		PrintDirAllPath2Txt t = new PrintDirAllPath2Txt();
//		t.getAllFileList(file);
		
		String str ="D:\\jboss-4.2.2.GA\\server\\default\\deploy\\shen3spnet.war\\aa\\bb";
		int i = str.indexOf("shen3spnet");
		int j = str.substring(i).indexOf("\\")+1;
		System.out.println(str.substring(i).substring(j));
		
	}
	
	
}
