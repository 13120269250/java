package singlepointlist;

public class SinglePointLinkedList {
	
	public int size  = 0;
	
	public Element headPoint;
	
    class Element{
    	public Object value = null;
    	Element next;
    }
    
    public void add(Element mElement){
    	size++;
    	if(headPoint==null){
    		headPoint = new Element();
    		headPoint .next = null;
    	}
    	Element mElementTemp = new Element();
    	mElementTemp.value = mElement;
    	
    	
    	//
    	mElementTemp.next = headPoint.next;
    	headPoint.next = mElementTemp;
    }
    
    public void remove(){
    	
    }
    
    public Element getElement(int i){
    	return null;
    }
}
