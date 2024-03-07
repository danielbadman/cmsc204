import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T> {

	private Comparator <T> comparator;
	
	public SortedDoubleLinkedList(Comparator <T> compareableObject) {
		head = null;
		tail = null;
		numberOfEntries = 0;
		comparator = compareableObject;
	}
	
	public void add(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else { 
			Node currentNode = head;
			boolean inserted = false;
			boolean atFront = false;
			
			while (currentNode != null && !inserted) {
				if (comparator.compare(newNode.data, currentNode.data) <= 0) {
					if (currentNode.prev != null) {
						currentNode.prev.next = newNode;
						newNode.prev = currentNode.prev;
					} else {
						atFront = true;
					}
					
					currentNode.prev = newNode;
					newNode.next = currentNode;
					inserted = true;
					if (atFront) {
						head = newNode;
					}
				}
				currentNode = currentNode.next;
			}
			
			if (!inserted) {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
		}
		numberOfEntries++;
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	public Node remove(T data, Comparator<T> comparator) {
		Node currentNode = head;
		while (currentNode != null)	{
			if (comparator.compare(currentNode.data, data) == 0) {
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
}
