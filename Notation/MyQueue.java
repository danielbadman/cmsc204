import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface<T> {
	
	private ArrayList<T> queue;
	private int backIndex;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 20;
	
	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public MyQueue(int capacity) {
		queue = new ArrayList<T>();
		backIndex = -1;
		this.capacity = capacity;
	}
	
	@Override
	public boolean isEmpty() {
		if (backIndex == -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (backIndex == capacity - 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()) {
			T temp = queue.get(0);
			queue.remove(0);
			backIndex--;
			return temp;
		} else {
			throw new QueueUnderflowException();
		}
		
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		} else {
			queue.add(e);
			backIndex++;
			return true;
		}
	}

	public String toString() {
		return toString("");
	}
	
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (T e : queue) {
			result += e.toString() + delimiter;
		}
		return result;
	}
	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		queue = new ArrayList<T>();
		backIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			enqueue(list.get(i));
		}
		
	}

}
