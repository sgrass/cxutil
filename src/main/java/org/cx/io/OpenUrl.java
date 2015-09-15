package org.cx.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class OpenUrl {

	public static void main(String[] args) throws IOException {
		/**执行步骤:
		 * 1.需要打开连接的URL
		 * 2.返回URLConnection对象
		 * 3.得到连接对象的getInputStream
		 * 4.写数据到本地文件,并且开始写数据
		 */
		URL url=new URL("ftp://accp_gongxiang:accp@192.168.1.200/工具/powerbuilder9/setup.bmp");
		
		URLConnection urc=url.openConnection(); 
		
		InputStream ins=urc.getInputStream();  
		
		FileOutputStream fout=new FileOutputStream("C:/accp.bmp"); 
		
		int i;
		while ((i=ins.read())!=-1) {
			fout.write(i);  
		}
		
		fout.close();
		ins.close();
	}

}
