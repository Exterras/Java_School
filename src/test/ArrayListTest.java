package test;

public class ArrayListTest {
	private int size = 0; // ArrayList의 개수
	private Object[] elementData = new Object[100];
	
	public boolean addLast(Object element){
		elementData[size] = element;
		size++;
		return true;
	}
	
	public boolean addFirst(Object element){
//		for (int i = size-1; i >= 0; i--) {
//			elementData[i+1] = elementData[i]; 
//		}
//		elementData[0] = element;
//		size++;
		add(0, element);
		return true;
	}
	
	public boolean add(int index, Object element){
		for (int i = size-1; i >= index; i--) {
			elementData[i+1] = elementData[i]; 
		}
		elementData[index] = element;
		size++;
		return true;
	}

	public static void main(String[] args) {
		ArrayListTest arrayList = new ArrayListTest();
		arrayList.addLast(10);
		arrayList.addLast(20);
		arrayList.addLast(30);
		arrayList.addLast(40);
		
		arrayList.add(1, 15);
		arrayList.addFirst(5);
	}
}
