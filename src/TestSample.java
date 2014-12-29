
public class TestSample {
	public String getName(){
		return null;
	}
	
	
	public static void main(String args[]){
		TestSample mSample = new TestSample(){

			@Override
			public String getName() {
				return "god";
			}
			
		};
		
		System.out.println(mSample.getName());
	}
}
