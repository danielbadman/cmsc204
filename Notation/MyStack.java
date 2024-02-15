import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T> {

	private ArrayList<T> stack;
	private int topIndex;
	
	public MyStack() {
		stack = new ArrayList<T>();
		topIndex = -1;
	}
	
	@Override
	public boolean isEmpty() {
		if (stack.get(0) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
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

	@SuppressWarnings("unchecked")
	public boolean push(T e) throws StackOverflowException {
		stack.add(e);
		return true;
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
	public void fill(ArrayList list) throws StackOverflowException {
	
		
	}
	
}
