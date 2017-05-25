package org.cx.http;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Crawl {

	public static void main(String[] args) throws Exception {
		String url_str = "http://s.etao.com/detail/522941627935.html";
		String charset = "utf-8";
		
		String filepath = "/Users/grass/Desktop/"+System.currentTimeMillis()+".html";

		String html = null;
		HttpClient hc = new DefaultHttpClient();
		HttpGet hg = new HttpGet(url_str);
		HttpResponse response = hc.execute(hg);
		int resStatu = response.getStatusLine().getStatusCode();//返回码  
    if (resStatu==HttpStatus.SC_OK) {
    	 //获得相应实体  
      HttpEntity entity = response.getEntity();  
      if (entity!=null) {  
          html = EntityUtils.toString(entity);
      }  
    } else {
    	System.out.println("出错了");
    }
    saveHtml(filepath, html);
	}

	public static void saveHtml(String filepath, String str) {

		try {
			/*
			 * @SuppressWarnings("resource") FileWriter fw = new FileWriter(filepath);
			 * fw.write(str); fw.flush();
			 */
			OutputStreamWriter outs = new OutputStreamWriter(new FileOutputStream(filepath, true), "GBK");
			outs.write(str);
			outs.close();
		} catch (IOException e) {
			System.out.println("Error at save html...");
			e.printStackTrace();
		}
	}

	public static String InputStream2String(InputStream in_st, String charset) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(in_st, charset));
		StringBuffer res = new StringBuffer();
		String line = "";
		while ((line = buff.readLine()) != null) {
			res.append(line);
		}
		return res.toString();
	}
}
