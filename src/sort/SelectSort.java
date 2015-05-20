package sort;

import java.util.Arrays;

public class SelectSort {

	
//	适合小数据量的排序和 分治后的排序
	public static void main(String args[]){
		int values [] ={234,234,54,234,54,34,34};
		selectSort(values);
		System.out.println(Arrays.toString(values));
	}
	
	
	
	private static void selectSort(int arrays[]){
		for(int i=0 ;i<arrays.length;i++){
		
			//使用i作为一个temp值 每次循环下来会得到一个最小的值 放在末尾
			for(int j=i+1 ;j<arrays.length;j++){
				//每次拿外层的数据和里面的数据每一个比较如果大就交换
				if(arrays[i]>arrays[j]){
					int valTemp = arrays[j];
					arrays[j]= arrays[i];
					arrays[i] = valTemp;
				}
				
				
			}
		}
	}
	
	
}
