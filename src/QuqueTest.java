import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QuqueTest {

    /*
     * 在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
     * Queue使用时要尽量避免Collection的add
     * ()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优
     * 点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 如果要使用前端而不移出该元素，使用
     * element()或者peek()方法。
     */
    public static void main(String args[]) {
        Queue<String> mQueue = new LinkedList<String>();
        mQueue.offer("first");
        mQueue.offer("second");
        String temp = null;
        while ((temp = mQueue.poll()) != null) {
            System.out.println(temp);
        }

        Queue<String> mQueueBlock = new ArrayBlockingQueue<String>(10);
        mQueueBlock.offer("first");
        mQueueBlock.offer("second");
        String tempBlock = null;
        while ((tempBlock = mQueueBlock.poll()) != null) {
            System.out.println(tempBlock);
        }
    }

}
