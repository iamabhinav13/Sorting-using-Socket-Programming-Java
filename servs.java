import java.net.*;
import java.util.*;
import java.io.*;
public class servs
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(8085);
			Socket s=ss.accept();
			System.out.println("Connected...");
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			int r,i=0;
			int n=din.readInt();
			int a[]=new int [n];
			System.out.println("DATA:");
			int count=0;
			System.out.println("Receiving Data...");
			for(i=0;i<n;i++)
			{
				a[i]=din.readInt();
			}
			System.out.println("Data received.");
			System.out.println("Sorting Data...");
			Arrays.sort(a);
			System.out.println("Data Sorted.");
			System.out.println("Sending Data...");
			for(i=0;i<n;i++)
			{
				dout.writeInt(a[i]);
			}
			System.out.println("Data sent successfully.");
			s.close();
			ss.close();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}