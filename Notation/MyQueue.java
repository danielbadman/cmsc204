import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface {
	
	private T[] queue;
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fill(ArrayList list) throws QueueOverflowException {
		// TODO Auto-generated method stub
		
	}

}