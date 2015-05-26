package search;


// KMP SEARCH is a CHAR search Algorithm (suanfa) which is found by k m p at the same time
// Licence is for userd Who want to 

// 一般的循环遍历 时间复杂度 O(m*n) 而 kmp 时间复杂度是O(m+n)



public class FindSubString {
	
	//最朴素的字符串查找
	public static int subString(String source, String subject){
		int srcLen = source.length();
		int subLen = subject.length();
		
		for(int i=0; i<srcLen-subLen; i++){
			int k = i;
			for(int j=0; j<subLen; j++,k++){
				if(source.charAt(k)!=subject.charAt(j))
					break;
				if(j == subLen-1)
					return i;
			}
		}
		return -1;
	}
	
   //BM 查找算法
	
	
	
	
	//借鉴Rabin-Karp算法(参见算法导论)
	public static int subStringRK(String source, String subject){
		int srcLen = source.length();
		int subLen = subject.length();
		int value = 0;
		int sourceValue = 0;
		for(int i=0; i<subLen; i++){
			value += subject.charAt(i);
			sourceValue += source.charAt(i);
		}
		int index = 0;
		while(index < (srcLen - subLen)){
			while((sourceValue != value)&&(index < (srcLen - subLen))){
				sourceValue = sourceValue - source.charAt(index) +source.charAt(index+subLen);
				index++;
			}
			
			for(int j=0,k=index; j<subLen; j++,k++){
				if(source.charAt(k) != subject.charAt(j)){
					index++;
					break;
					}
				if(j == (subLen -1))
					return index;
			}	
		}
		return -1;
	}
	
	//KMP算法(参见算法导论)
	public static int subStringKMP(String source, String subject){
		int srcLen = source.length();
		int subLen = subject.length();
		int[] pattern = new int[subLen];
		prefix(subject, pattern);
		
		for(int index=0,p=0; index<srcLen; index++){
			if(source.charAt(index) == subject.charAt(p)){
				p++;
				if(p == subLen)
					return index - subLen + 1;
			}else{
				p = pattern[p];
			}	
		}	
		return -1;
	}
	//跳转前缀函数
	private static void prefix(String subject,int[] pattern){
//		int[] p = {0,0,1,2,3,4,5,6,0,1};
//		pattern = p; 
		int subLen = subject.length();
		pattern[0] = 0;
		for(int i=1,k=0; i<subLen; i++){
			while ((subject.charAt(i) != subject.charAt(k)) && k > 0){
				k = pattern[k];				
			} 		
			if(subject.charAt(i) == subject.charAt(k)){
				k++;
			}
			pattern[i] = k;
		}
//		for(int p: pattern)
//			System.out.print(p);
	} 
	
	public static void main(String[] args){
		String source = "asgwebcdefghijkababababcalmn";
		String subject = "ababababca";
		
		System.out.println(subString(source,subject));
		System.out.println(subStringRK(source,subject));
		System.out.println(subStringKMP(source,subject));
	}
}
