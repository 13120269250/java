package sort;

import java.util.Arrays;

//for 冒泡排序

public class BubbleSort {
	
	public static void main(String args[]){
		int arrays []= {12,23,1,2,43,2,1,3,4,5,2};
		bubbleSort(arrays);
		System.out.println(Arrays.toString(arrays));
	}

	
	public static void bubbleSort(int sort[]){
		//第一层 只做次数用不参与比较
		for(int i =0;i<sort.length;i++){
			//第二层两个相邻的之间互相比较 每一次循环得出一个最大的值放在最前面
			for(int j= 1;j<sort.length-i;j++){
				if(sort[j-1]>sort[j]){
					int temp = sort[j];
					sort[j]= sort[j-1];
					sort[j-1]= temp;
					}
				}
			}
	}
}
