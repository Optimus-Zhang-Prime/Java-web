package server;//必须在第一行
import java.io.*;
import java.net.*;


public class TCP1_client {
    public static void main(String[] args)throws Exception{
        new TCPclient().connect();
    }
}
class TCPclient{
    private static final int PORT=9999;//服务器端口号
    void connect() throws Exception{
        Socket client=new Socket(InetAddress.getLocalHost(),PORT);//ip为本机ip
        InputStream is=client.getInputStream();//从服务器读取数据
        byte[] buf=new byte[1024];
        int len=is.read(buf);
        System.out.println(new String(buf,0,len));
        OutputStream os=client.getOutputStream();//向服务端发送数据
        os.write(("客户端收到了").getBytes());
        os.close();
        is.close();
        client.close();


    }
}
