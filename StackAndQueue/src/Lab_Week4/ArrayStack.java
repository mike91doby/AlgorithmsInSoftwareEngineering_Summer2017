package Lab_Week4;

import java.util.Arrays;

public class ArrayStack {
	private int[] data;
	private int head;
	private int tail;
	
	public ArrayStack(int size) {
		data = new int[size];
		clear();
		head = 0;
		tail = -1;
	}
	
	public void clear() {
		Arrays.fill(data, -1);
		tail = -1;
	}
	
	public void push(int element) {
		// incase the array is not big enough to push another element
		if(tail >= data.length) {
			int temp[] = new int[data.length * 2];
			for(int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
		// push the element
		int dataSize = this.size();
		data[dataSize] = element;
		tail++;
	}
	
	public int pop() {
		int result = -1;
		if(tail > -1) {
			int dataSize = this.size();
			result = data[dataSize-1];
			data[dataSize-1] = -1;
			tail--;
		}
		return result;
	}
	
	public int size() {
		return tail + 1;
	}
	
	public boolean find(int element) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == element) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(int element) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == element) {
				return i;
			}
		}
		return -1;
	}
}