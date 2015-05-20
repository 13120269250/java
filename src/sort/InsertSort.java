package sort;

import java.util.Arrays;

public class InsertSort {
	
//	idea
//	　这个算法从数组的第二个元素开始循环，将选中的元素与之前的元素一一比较，如果选中的元素小于之前的元素，
//	 则将之前的元素后移，
//	 最后再将选中的元素放在合适的位置。在这个算法执行的过程中，总是保持着索引i之前的数组是升序排列的。
	
	
	public static void main(String args[]){
		 int array [] = {23,43,1,23,45,23,53,23,5,3,2,3};
		 sort(array);
		 System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] numbers){
		
        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            int j = i - 1;
            
            //对于临界点的把控
            while (j >= 0 && numbers[j] > currentNumber) {
                numbers[j + 1] = numbers[j];
                j--;
               
            }
            
            
            //把刚才替换掉的补位上去
            numbers[j + 1] = currentNumber;
            System.out.println(Arrays.toString(numbers));
            
            
        }
    }
	
	
	
	
	private static void changePosition(int arrays[] ,int i ,int j){
		int temp = i;
		i = j;
		j = temp;
	}
}
