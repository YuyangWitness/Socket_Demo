import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {


            try {
                InetAddress inet1 = InetAddress.getByName("www.baidu.com");
                System.out.println(inet1);
                InetAddress  inet2 = InetAddress.getByName("127.0.0.1");
                System.out.println(inet2);
                InetAddress  inet3 = InetAddress.getLocalHost();
                System.out.println(inet3);
                System.out.println(inet3.getHostAddress());
                System.out.println(inet3.getHostName());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

    }
}
