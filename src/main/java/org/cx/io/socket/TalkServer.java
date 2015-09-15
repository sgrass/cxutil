package org.cx.io.socket;

import java.io.*;
import java.net.*;

public class TalkServer {
	
	public static void main(String args[]) throws IOException {
		ServerSocket server=new ServerSocket(9999);		
		Socket socket=server.accept();		

		BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));		
		
		PrintStream os=new PrintStream(socket.getOutputStream());		
		
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));		
		
		System.out.println("Client:"+is.readLine());   
		
		String s;
		while((s=sin.readLine())!=null)
		{
			os.println(s);   
			System.out.println("Client:"+is.readLine());    
			os.flush();
		}				
		server.close();
	}
}
