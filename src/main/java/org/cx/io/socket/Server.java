package org.cx.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Created on 2005-11-6
 */
public class Server extends Thread
{
	protected BufferedReader in;		//定义一个输入流，用于从客户端读数据
	protected PrintStream ps;			//定义输出流，用于想客户端写数据
	public Server(InputStream i,OutputStream o)		//构造输入流
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
				System.out.println("客户端：   "+line);		//从客户端读取数据
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
	public static void main(String[] args) throws IOException 
	{
		ServerSocket server=new ServerSocket(8888);
		System.out.println("服务器已经启动等待用户的请求:");
		Socket s=server.accept();			//服务器开始等待
		System.out.println("线程qian");
		Server myserver=new Server(s.getInputStream(),s.getOutputStream());		//创建一个自定义对象
		myserver.start();//启动线程
		System.out.println("线程hou");
		try
		{
//			定义输入流用于从控制台获取输入
			BufferedReader infor=new BufferedReader(new InputStreamReader(System.in));
			String infline;
			while((infline=infor.readLine())!=null)
			{
				myserver.ps.println(infline);//向客户端写如数据
				System.out.println("输入数据");
				//Thread.sleep(1000);			//线程等待一秒
			}
			System.out.println("输入数据循环完后");
		}
		catch(Exception em){}
		finally
		{
			myserver.ps.close();		//将输出流关闭
		}
	}
}
