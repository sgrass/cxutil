package org.cx.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties文件
 * @author grass
 *
 */
public class GetProperties {

	//获取当前系统临时目录(没试过linux)
	public String getComputerTempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
    InputStream is = ClassLoader.getSystemResourceAsStream("test.properties");
    properties.load(is);
    is.close();
    System.out.println(properties.getProperty("test"));
	}

}
