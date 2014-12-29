import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class EmsSocket {

    public static void main(String args[]){
        try {
            Socket mSocket = new Socket("server.lcemsg.com" ,4222);
            System.out.println(mSocket.getSoTimeout());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println();
        }
    }
}
