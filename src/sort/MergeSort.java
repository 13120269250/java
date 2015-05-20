package sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	
//	分治以后 在复制到新的数组 需要占用相关的空间 .利用空间换时间 。可以考虑并行的算法
	public static void main(String args[]) throws IOException{
//		System.out.println("请输入数据用＃号隔开");
//		  BufferedReader strin2=new BufferedReader(new InputStreamReader(System.in));
//		  String arrays= strin2.readLine();
//		  String arrayDatas []  = arrays.split("#");
//		  System.out.println(Arrays.toString(arrayDatas));
		
		
		Scanner sc=new Scanner(System.in);
		int[] array=new int[6];
		for(int i=0;i<array.length;i++){
		        System.out.println("老爸给我钱");
		        array[i]=sc.nextInt();
		}
		sort(array, 0, 6);
		 System.out.println("老爸每次给钱多少顺序");
		System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] numbers,int pos,int end){
        if ((end - pos) > 1) {
            int offset = (end + pos) / 2;
            sort(numbers, pos, offset);
            sort(numbers, offset, end);
            merge(numbers, pos, offset, end);
        }
    }
    
    public static void merge(int[] numbers,int pos,int offset,int end){
        int[] array1 = new int[offset - pos];
        int[] array2 = new int[end - offset];
        System.arraycopy(numbers, pos, array1, 0, array1.length);
        System.arraycopy(numbers, offset, array2, 0, array2.length);
        for (int i = pos,j=0,k=0; i < end ; i++) {
            if (j == array1.length) {
                System.arraycopy(array2, k, numbers, i, array2.length - k);
                break;
            }
            if (k == array2.length) {
                System.arraycopy(array1, j, numbers, i, array1.length - j);
                break;
            }
            if (array1[j] <= array2[k]) {
                numbers[i] = array1[j++];
            } else {
                numbers[i] = array2[k++];
            }
        }
    }
    

}
