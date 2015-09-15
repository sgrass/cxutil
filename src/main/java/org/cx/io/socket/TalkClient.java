package org.cx.io.socket;

import java.io.*;
import java.net.*;

public class TalkClient {
	
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",9999);
		
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
				
		PrintStream os=new PrintStream(socket.getOutputStream());
		
		BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
//		System.out.println("Server:"+is.readLine());
		
		String s;
		while((s=sin.readLine())!=null) {
			os.println(s);   
			System.out.println("Server:"+is.readLine());
			os.flush();			
		}		
		socket.close();
	} 
}
