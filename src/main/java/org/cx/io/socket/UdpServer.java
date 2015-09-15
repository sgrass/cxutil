package org.cx.io.socket;

import java.io.*;
import java.net.*;

public class UdpServer 
{
	public static void main(String[] args) throws IOException
	{
		DatagramSocket s=new DatagramSocket(5656);
		byte[] bj=new byte[1024];
		DatagramPacket dataj=new DatagramPacket(bj,bj.length);

		DatagramSocket f=new DatagramSocket();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		byte[] bf=new byte[1024];
		

		while(true)
		{
			s.receive(dataj);
			System.out.println("客户端消息:"+new String(dataj.getData(),0,dataj.getLength()));
			String str;
			str=br.readLine();
			bf=str.getBytes();
			DatagramPacket dataf=new DatagramPacket(bf,bf.length,InetAddress.getByName("localhost"),8888);
			f.send(dataf);
		}	
//		f.close();
//		s.close();
	}
}
