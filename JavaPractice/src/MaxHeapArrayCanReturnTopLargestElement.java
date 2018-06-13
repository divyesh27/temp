public class MaxHeapArrayCanReturnTopLargestElement {

	private static MaxHeapArrayCanReturnTopLargestElement maxHeap;
	private int[] heap;
	private int capacity;
	private int position;
	
	public MaxHeapArrayCanReturnTopLargestElement(int cap) {
		position = 1;
		capacity = cap;
		heap = new int[capacity];
	}
	
	public void insert(int val) {
		if(position == capacity) {
			
		}
		else {
			heap[position++] = val;
			
			int child = position - 1;
			int parent = child / 2;
			
			while(heap[parent] < heap[child] && parent > 0) {
				int temp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = temp;
				
				child = parent;
				parent = child/2;
			}
			
		}
	}
	
	public void print() {
		for(int i = 1; i < position; i++) {
			System.out.print(heap[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		maxHeap = new MaxHeapArrayCanReturnTopLargestElement(10);
		maxHeap.insert(12);
		maxHeap.insert(7);
		maxHeap.insert(6);
		maxHeap.insert(10);
		maxHeap.insert(8);
		maxHeap.insert(20);
		maxHeap.print();
	}
}