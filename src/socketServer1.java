import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yangyu on 16/6/12.
 *
 * 这是服务器,通过端口来获取客户端的连接,然后也是通过I/O流来输入和输出,相比与客户端,服务端多了一个ServerSocket来accept客户端;
 * 最后别忘了关闭流和Socket
 */
public class socketServer1 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;

        int port = 10000;

        try {
            //建立连接
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();

            //获取输入流,获取客户端信息
            is = socket.getInputStream();
            byte[] b = new byte[1024];
            int n = is.read(b);
            System.out.println("客户端信息为 : "+new String(b,0,n));


            //输出流,向客户端发送反馈信息
            os = socket.getOutputStream();
            os.write(b,0,n);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
