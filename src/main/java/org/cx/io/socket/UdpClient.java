package org.cx.io.socket;

import java.io.*;
import java.net.*;

public class UdpClient 
{
	public static void main(String[] args) throws IOException
	{
		DatagramSocket f=new DatagramSocket();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		byte[] bf=new byte[1024];
		
		DatagramSocket s=new DatagramSocket(8888);
		byte[] b=new byte[1024];
		DatagramPacket data=new DatagramPacket(b,b.length);

		while(true)
		{
			String str;
			str=br.readLine();
			bf=str.getBytes();
			DatagramPacket dataf=new DatagramPacket(bf,bf.length,InetAddress.getByName("localhost"),5656);
			f.send(dataf);
			s.receive(data);
			System.out.println("服务器端消息:"+new String(data.getData(),0,data.getLength()));
		}	
//		f.close();
//		s.close();		
	}
}
