import java.net.*;
import java.util.*;
import java.io.*;
public class clis
{
	public static void main(String args[])
	{
		try
		{
			Socket s=new Socket("localhost",8085);
			if(s.isConnected())
			{
				System.out.println("Connected to server...");
			}
			System.out.print("Enter the size of array:");
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int a[]=new int[n];
			System.out.println("Enter the elements of array:");
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeInt(n);
			for (int i=0;i<n;i++) 
			{
				int r=scanner.nextInt();
				dout.writeInt(r);	
			}
			System.out.println("Data Sent.");
			DataInputStream din=new DataInputStream(s.getInputStream());
			int r;
			System.out.println("Receiving sorted data...");
			for(int i=0;i<n;i++)
			{
				r=din.readInt();
				System.out.println(r+" ");
			}
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}