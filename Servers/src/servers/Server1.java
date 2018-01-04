/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

/**
 *
 * @author absolute49
 */

import com.mysql.jdbc.Connection;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Server1 {
	public  void main()throws IOException{
		ServerSocket s=new ServerSocket(5050);
		while(true)
		{
			Socket t=s.accept();
			System.out.println("new Client Connected");
			Thread c=new clientHandler(t);
			c.start();
		}



	}
}
class clientHandler extends  Thread
{       StringBuffer path;
	FileOutputStream fos;
	DataInputStream dis;
	DataOutputStream dos;
	FileInputStream fis;
	byte []buffer =new byte[1024];
	static volatile long threadCount=5;
	long threadno;
	public clientHandler(Socket s) throws IOException
	{
		threadCount++;
		this.threadno=threadCount;
                String str="/home/absolute49/Videos/";
                 path=new StringBuffer();
                path.append(str);
                path.append(threadno);
                path.append(".mp4");
		this.fos=new FileOutputStream(path.toString());
		this.dos=new DataOutputStream(s.getOutputStream());
		this.dis=new DataInputStream((s.getInputStream()));
		this.fis=(FileInputStream)s.getInputStream();

	}
	public void run()
	{
		try {
			dos.writeUTF("tell me your name");
			String name = dis.readUTF();
			System.out.println(name);
			dos.writeUTF("Subject");
			String Subject=dis.readUTF();
			dos.writeUTF("Topic");
		         String Topic =dis.readUTF();
                         dos.writeUTF("TEll me your Heading");
                         String head=dis.readUTF();
			while (fis.read(buffer, 0, 1024) > 0) {
				//System.out.println(buffer.length);
				fos.write(buffer);
			}
			this.dos.close();
			this.dis.close();
			this.fis.close();
			this.fos.close();
                        Connection c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root",null);
                        PreparedStatement st=c.prepareStatement("Insert Into Videos(byuser,path,topic,Subject,heading) Values(?,?,?,?,?)");
                        st.setString(1,name);
                        st.setString(2,"ftp://172.31.80.232/"+threadno+".mp4");
                        st.setString(3, Topic);
                        st.setString(4,Subject);
                        st.setString(5,head);
                        int r=st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

