import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QuqueTest {

    /*
     * ���java5涓���板�����浜�java.util.Queue��ュ�ｏ����ㄤ互���������������甯歌�����浣����璇ユ�ュ�ｆ�╁��浜�java.util.Collection��ュ�ｃ��
     * Queue浣跨�ㄦ�惰��灏介����垮��Collection���add
     * ()���remove()��规��锛�������瑕�浣跨��offer()��ュ����ュ��绱�锛�浣跨��poll()��ヨ�峰��骞剁Щ��哄��绱����瀹�浠����浼�
     * ��规�����杩�杩������煎��浠ュ�ゆ��������涓����锛�add()���remove()��规����ㄥけ璐ョ����跺��浼������哄��甯搞�� 濡����瑕�浣跨�ㄥ��绔����涓�绉诲�鸿�ュ��绱�锛�浣跨��
     * element()������peek()��规�����
     */
    public static void main(String args[]) {
//        Queue<String> mQueue = new LinkedList<String>();
//        mQueue.offer("first");
//        mQueue.offer("second");
//        String temp = null;
//        while ((temp = mQueue.poll()) != null) {
//            System.out.println(temp);
//        }
//
//        Queue<String> mQueueBlock = new ArrayBlockingQueue<String>(10);
//        mQueueBlock.offer("first");
//        mQueueBlock.offer("second");
//        String tempBlock = null;
//        while ((tempBlock = mQueueBlock.poll()) != null) {
//            System.out.println(tempBlock);
//        }
        int array [] =new int[]{123,234,234,43};
       // bubbleForOrder(array);
    	//selectCommon(array,0);
        quickForOrder(array,0,2);
    	System.out.println(array);
    }
    
    public static void selectCommon(int [] array , int current){
    	while(current < array.length){
    		for(int i = current ;i<array.length ;i++){
    			if(array[current]> array[i]){
    				int temp = array[i];
    				array[i] = array[current];
    				array[current] = temp;
    			}
    		}
    		current++;
    		selectCommon(array, current);
    	}
    }
    
  // for mao pao
    public  static void  bubbleForOrder(int [] array) {
		
    	
    	for(int i =0 ;i<array.length;i++){
    		for(int j =1 ;j<array.length-i;j++){
    			if(array[j-1]>array[j]){
    				int temp = array[j];
    				array[j] =array [j-1];
    				array[j-1] =temp;
    			}
    		}
    		
    	}
	}
    
    //思路：划分步骤：通过枢轴元素 x 将序列一分为二， 且左子序列的元素均小于 x，右子序列的元素均大于 x；治理步骤：递归的对左、右子序列排序；
    
    public static void quickForOrder(int array [], int low ,int high){
    	if (low < high) {
    		int part = partition(array,low,high);
    		
    		quickForOrder(array, low, part - 1);

    		quickForOrder(array, part + 1, high);

		}
    }
    
    
   static  int partition(int[] a, int low, int high) {

		int tar = a[low];

		while (low < high) {// 循环该段数据

			while (low < high && tar < a[high])// 先从高端开始查找

				high--;

			a[low] = a[high];// 交换数据

			while (low < high && tar > a[low])// 再从低端开始查找

				low++;

			a[high] = a[low];// 交换数据

		}

		a[low] = tar;// 重新设置枢轴

		return low;// 返回枢轴位置

   }
}
