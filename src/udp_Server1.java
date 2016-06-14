import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by yangyu on 16/6/12.
 *
 * 这是服务器,获取信息和反馈信息!
 */
public class udp_Server1 {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket send = null;
        DatagramPacket received = null;
        int port = 10000;


        try {
            //建立连接
            ds = new DatagramSocket(port);

            //初始化获取数据
            byte[] reData = new byte[1024];
            received = new DatagramPacket(reData,reData.length);
            ds.receive(received);

            //获取数据
            InetAddress address = received.getAddress();
            int Clientport = received.getPort();
            byte[] getData = received.getData();
            int len = received.getLength();

            //输出数据
            System.out.println("获取客户端IP :"+address);
            System.out.println("获取客户端端口 :"+Clientport);
            System.out.println("获取数据 :"+new String(getData,0,len));

            //初始化发送数据
            String hello = "hello";
            byte[] data = hello.getBytes();
            send = new DatagramPacket(data,data.length,address,Clientport);

            //发送反馈消息
            ds.send(send);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
