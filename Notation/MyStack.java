import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T> {

	private ArrayList<T> stack;
	private int topIndex;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 20;
	
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}

	public MyStack(int capacity) {
		stack = new ArrayList<T>();
		topIndex = -1;
		this.capacity= capacity; 
	}
	
	@Override
	public boolean isEmpty() {
		if (topIndex == -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (topIndex == capacity) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()) {
			T temp = stack.get(topIndex);
			stack.remove(topIndex);
			topIndex--;
			return temp;
		} else {
			throw new StackUnderflowException();
		}
		
	}

	@Override
	public T top() throws StackUnderflowException {
		if (!isEmpty()) {
			return stack.get(topIndex);
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public int size() {
		return stack.size();
	}

	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		} else {
			stack.add(e);
			topIndex++;
			return true;
		}
	}

	@Override
	public String toString(String delimiter) {
		String result = "";
		for (T e : stack) {
			result = e.toString() + delimiter + result;
		}
		return result;
	}

	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		stack = new ArrayList<T>();
		topIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			push(list.get(i));
		}
	}
	
}
