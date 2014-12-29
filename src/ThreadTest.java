import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class ThreadTest {
    
    public static void main(String args []) throws InterruptedException{
        
        ThreadTest mTest = new ThreadTest();
        Thread myThread = new Thread(mTest.new MyRunable());
        myThread.start();
        
        Thread.sleep(3*1000);
        
        myThread.interrupt();
     
       try {
        Socket mSocket = new Socket("",2332);
    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    
    
    //Test interrupt method
    public class MyRunable implements Runnable{

        @Override
        public void run() {
            try {
            for(int i = 0;i <1000;i++){
                
                System.out.println("current i"+i);
                    Thread.sleep(2000);
               
            }
            } catch (InterruptedException e) {
                System.out.println("thread interrupt"+ Thread.currentThread().getId());
            }
            System.out.println("thread over"+ Thread.currentThread().getId());
        }
        
    }
    
   /* Thread.yield():

    pi中解释： 暂停当前正在执行的线程对象，并执行其他线程。 
                注意：这里的其他也包含当前线程，所以会出现以下结果。
    1.public class Test extends Thread {   
    2.   public static void main(String[] args) {    
    3.     for (int i = 1; i <= 2; i++) {    
    4.       new Test().start();    
    5.    }   
    6.  }   
    7.  
    8.   public void run() {    
    9.     System.out.print("1");    
    10.    yield();   
    11.     System.out.print("2");    
    12.  }   
    13.}  */


}
