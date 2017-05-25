package org.cx.http;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;

public class JsoupTest {

	public static void main(String[] args) throws IOException {
    String url = "http://item.jumeiglobal.com/ht151109p1599419t2.html";
    String html = Jsoup.connect(url).execute().body();  
    
    String filepath = "/Users/grass/Desktop/test.html";
    OutputStreamWriter outs = new OutputStreamWriter(new FileOutputStream(filepath, true), "utf-8");
		outs.write(html);
		outs.close();
	}

}
