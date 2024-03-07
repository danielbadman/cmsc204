import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList <T> implements Iterable<T>{
	
	
	protected Node head;
	protected Node tail;
	protected int numberOfEntries;
	
	protected BasicDoubleLinkedList() {
		head = null;
		tail = null;
		numberOfEntries = 0;
	}
	
	protected void addToEnd(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = tail.next;
		}
		numberOfEntries++;
	}
	
	protected void addToFront(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = head.prev;
		}
		numberOfEntries++;
	}
	
	protected T getFirst() {
		if (!isEmpty()) {
			return head.data;
		} else {
			return null;
		}
	}
	
	protected T getLast() {
		if (!isEmpty()) {
			return tail.data;
		} else {
			return null;
		}
	}
	
	protected int getSize() {
		return numberOfEntries;
	}
	
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	protected Node remove(T targetData, Comparator<T> comparator) {
		Node currentNode = head;
		while (currentNode != null)	{
			if (comparator.compare(currentNode.data, targetData) == 0) {
				if (currentNode.prev != null && currentNode.next != null) {
					currentNode.prev.next = currentNode.next;
					currentNode.next.prev = currentNode.prev;
				} else if (currentNode.prev == null && currentNode.next != null){
					head = head.next;
					head.prev = null;
				} else if (currentNode.prev != null && currentNode.next == null) {
					tail = tail.prev;
					tail.next = null;
				} else if (currentNode.prev == null && currentNode.next == null) {
					head = null;
					tail = null;
				}
				numberOfEntries--;
				return currentNode;
			}
			currentNode = currentNode.next;
		}
		return null;
		
	}
	
	protected T retrieveFirstElement() {
		if (!isEmpty()) {
			T temp = head.data;
			if (head.next != null) {
				head = head.next;
				head.prev = null;
			} else {
				head = null;
			}
			numberOfEntries--;
			return temp;
		} else {
			return null;
		}
	}
	
	protected T retrieveLastElement() {
		if (!isEmpty()) {
			T temp = tail.data;
			if (tail.prev != null) {
				tail = tail.prev;
				tail.next = null;
			} else {
				tail = null;
			}
			numberOfEntries--;
			return temp;
		} else {
			return null;
		}
	}
	
	protected ArrayList<T> toArrayList() {
		ArrayList<T> arrList = new ArrayList<>();
		DoubleLinkedListIterator iter = new DoubleLinkedListIterator();
		
		while (iter.hasNext()) {
			arrList.add(iter.next());
		}
		
		return arrList;
	}
	
	protected boolean isEmpty() {
		if (numberOfEntries == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		Node cursor;

		public DoubleLinkedListIterator() {
			cursor = new Node(null);
			cursor.next = head;
		}
		
		@Override
		public boolean hasNext() {
			if (cursor.next != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				cursor = cursor.next;
				return cursor.data;
			}
		}

		@Override
		public boolean hasPrevious() {
			if (cursor.prev != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			} else {
				cursor = cursor.prev;
				return cursor.data;
			}
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}
		
	}
	
	protected class Node {
		T data;
		Node next;
		Node prev;
		
		Node (T dataNode) {
			this(dataNode, null, null);
		}
		
		Node (T dataNode, Node next, Node prev) {
			data = dataNode;
			this.next = next;
			this.prev = prev;
		}
	}
	
	
}
