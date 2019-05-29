package server;//必须在第一行
import java.io.*;
import java.net.*;


public class TCP1_server {
    public static void main(String[] args)throws Exception{
        new TCPServer().listen();
    }
}
class TCPServer{
    private static final int PORT=9999;//服务器端口号
    void listen() throws Exception{
        ServerSocket serverSocket=new ServerSocket(PORT);//ServerSocket对象
        Socket client=serverSocket.accept();//有客户端与服务器连接时返回一个Socket对象
        OutputStream os=client.getOutputStream();//向客户端发送数据
        System.out.println("连接成功开始交互");
        os.write(("客户端收到请回答").getBytes());
        InputStream is=client.getInputStream();//从客户端读取数据
        byte[] buf=new byte[1024];
        int len=is.read(buf);
        System.out.println(new String(buf,0,len));
        os.close();
        client.close();


    }
}
