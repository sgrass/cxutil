package org.cx.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * Created on 2005-11-6
 */
public class Client extends Thread
{
	protected BufferedReader in;		//定义一个输入流，用于从客户端读数据
	protected PrintStream ps;			//定义输出流，用于想客户端写数据
	public Client(InputStream i,OutputStream o)		//构造输入流
	{
		in=new BufferedReader(new InputStreamReader(i));
		ps=new PrintStream(o);
	}
	public void run()	//重写run方法
	{
		System.out.println("please enter 'exit/EXIT' to quit");
		try
		{
			String line;
			while((line=in.readLine())!=null)
			{
				System.out.println("线程中");
				System.out.println("服务器端：   "+line);		//从服务器读取数据
				if(line.equalsIgnoreCase("Exit"))
				{
					in.close();
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("流已经关闭");
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Socket client=new Socket("localhost",8888);		//打开客户端
		System.out.println("线程前");
		Client myclient=new Client(client.getInputStream(),client.getOutputStream());
		myclient.start();
		System.out.println("线程hou");
		try
		{
//			定义输入流用于从控制台获取输入
			BufferedReader infor=new BufferedReader(new InputStreamReader(System.in));
			String infline;
			while((infline=infor.readLine())!=null)
			{
				myclient.ps.println(infline);		//向客户端写如数据
				System.out.println("输入数据");
				Thread.sleep(1000);			//线程等待一秒
			}
			System.out.println("输入数据循环完后");
		}
		catch(Exception em){}
		finally
		{
			myclient.ps.close();
		}
		
	}
}
