import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yangyu on 16/6/12.
 * 我必须纪念我的第一次网络编程,虽然这个是超级超级简单,未来看到这些会觉得自己超级幼稚,但是我必须记录下来,哈哈哈
 *
 * 这是客户端,先通过端口和IP连接服务器,然后通过I/O流来输入和输出,最后一定要记得关闭输入输出流和Socket!
 */
public class socketClient1 {
    public static void main(String[] args) {
        //现在try外面定义变量,这个很重要
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        //定义服务器Ip
        String Serverip = "127.0.0.1";
        //服务器的端口
        int Serverport = 10000;

        //发送内容
        String data = "hello";
        try {
            //建立连接
            socket = new Socket(Serverip,Serverport);

            //发送数据
            outputStream = socket.getOutputStream();
            outputStream.write(data.getBytes());

            //接收数据
            inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int n = inputStream.read(b);

            System.out.println("服务器反馈信息 : "+new String(b,0,n));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                outputStream.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
