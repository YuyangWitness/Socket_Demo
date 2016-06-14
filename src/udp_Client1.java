import java.io.IOException;
import java.net.*;
import java.util.Date;

/**
 * Created by yangyu on 16/6/12.
 *
 * 学习udp协议之间进行通信和信息的发送,主要利用了DatagramSocket进行建立连接,利用DatagramPacket打包发送信息和发送信息。
 * 这是客户端
 */
public class udp_Client1 {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket received = null;
        DatagramPacket send = null;
        int port = 10000;
        String ServerIP = "127.0.0.1";


        try {
            //创立连接
            ds = new DatagramSocket();

            //初始化发送数据

            Date date = new Date();
            String d = date.toString();
            byte[] sendData = d.getBytes();

            //初始化发送包
                InetAddress inetAddress = InetAddress.getByName(ServerIP);

            send = new DatagramPacket(sendData,sendData.length,inetAddress,port);

            //发送
            ds.send(send);


            //获取数据初始化
            byte[] receivedData = new byte[5];
            received = new DatagramPacket(receivedData,receivedData.length);
            ds.receive(received);

            //获取数据显示
            byte[] respond = received.getData();
            String s = new String(respond,0,respond.length);
            System.out.println("服务器反馈信息:"+s);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
