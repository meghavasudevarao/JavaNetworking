package TaskB;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.util.StringTokenizer;


public class UDPClientWithProxy {
	static String opr="+";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int res=0;
		for (int i=0;i<=100;i++)
		{
			res= res+(add(0,i));
        
		}
		 System.out.println("Result is: " +res);
	}
	
	public static int add (int x,int y)
	{
		
		DatagramSocket ds= null ;
        byte buf[] = null;
        String ans="0";
        
        
        
        
        try
        {
			 ds = new DatagramSocket();
			 
		        InetAddress ip = InetAddress.getLocalHost();
			
	            buf = new byte[65535];
	 
	            // convert the String input into the byte array.
	      
	           
	            String inp = Integer.toString(x)+" "+ opr+" "+Integer.toString(y);
	            
		          

		          buf = inp.getBytes();
	           
	           
	           
	           
	            // Step 2:Create the datagramPacket for sending the data.
	            DatagramPacket DpSend =
	                      new DatagramPacket(buf, buf.length, ip, 1234);
	 
	            // invoke the send call to actually send the data.
	            ds.send(DpSend);
	 
	 
	            buf = new byte[65535];
	            DatagramPacket DpReceive =
	                                 new DatagramPacket(buf, buf.length);
	            ds.receive(DpReceive);
	 
	           
	                               ans=  new String(buf,0,buf.length);	
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(ds != null) ds.close();}
		
		
		
		
		
		
		
		
		return Integer.parseInt(ans.trim());
	}
	

}
