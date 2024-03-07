
/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ListIterator;

class BasicDoubleLinkedListTest_STUDENT {

	BasicDoubleLinkedList<String> basicList;
	
	@BeforeEach
	void setUp() throws Exception {
		basicList = new BasicDoubleLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		basicList = null;
	}

	@Test
	void testGetSize() {
		basicList.addToFront("Cornell");
		basicList.addToEnd("Princeton");
		basicList.addToEnd("Harvard");
		assertEquals(3, basicList.getSize());
	}

	@Test
	void testAddToEnd() {
		basicList.addToEnd("Architect");
		basicList.addToEnd("Engineer");
		basicList.addToEnd("Mathematician");
		assertEquals("Mathematician", basicList.toArrayList().get(basicList.getSize() - 1));
	}

	@Test
	void testAddToFront() {
		basicList.addToFront("Apple");
		basicList.addToFront("Banana");
		basicList.addToFront("Orange");
		assertEquals("Orange", basicList.toArrayList().get(0));

	}

	@Test
	void testGetFirst() {
		assertEquals(null, basicList.getFirst());
		basicList.addToFront("Snapple");
		basicList.addToEnd("Brisk");
		basicList.addToFront("Arizona");
		assertEquals("Arizona", basicList.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals(null, basicList.getLast());
		basicList.addToFront("Snapple");
		basicList.addToEnd("Brisk");
		basicList.addToFront("Arizona");
		assertEquals("Brisk", basicList.getLast());
	}

	@Test
	void testIterator() {
		basicList.addToEnd("Helloo");
		basicList.addToFront("Bye Bye");
		basicList.addToEnd("KanKan");
		basicList.addToFront("Summrs");
		ListIterator iter = basicList.iterator();
		assertTrue(iter.hasNext());
		assertEquals("Summrs", iter.next());
		assertEquals("Bye Bye", iter.next());
		assertEquals("Helloo", iter.next());
		assertEquals("KanKan", iter.next());
		assertFalse(iter.hasNext());
		assertEquals("Helloo", iter.previous());
		assertEquals("Bye Bye", iter.previous());
		assertEquals("Summrs", iter.previous());
		assertFalse(iter.hasPrevious());
	}

	@Test
	void testRemove() {
		
		basicList.addToEnd("Quagmire");
		basicList.addToEnd("Joe");
		basicList.addToEnd("Cleveland");
		basicList.addToEnd("Peter");
		assertEquals("Joe", basicList.remove("Joe", new StringComparator()).data);
		assertEquals(3, basicList.getSize());
	}

	@Test
	void testRetrieveFirstElement() {
		basicList.addToEnd("Osamason");
		basicList.addToFront("Nettspend");
		basicList.addToEnd("Xaviersobased");
		basicList.addToEnd("Lazer Dim 700");
		assertEquals("Nettspend", basicList.retrieveFirstElement());
		assertEquals("Osamason", basicList.retrieveFirstElement());
		assertEquals("Xaviersobased", basicList.retrieveFirstElement());
		assertEquals("Lazer Dim 700", basicList.retrieveFirstElement());
		assertEquals(null, basicList.retrieveFirstElement());
	}

	@Test
	void testRetrieveLastElement() {
		basicList.addToEnd("Osamason");
		basicList.addToFront("Nettspend");
		basicList.addToEnd("Xaviersobased");
		basicList.addToEnd("Lazer Dim 700");
		assertEquals("Lazer Dim 700", basicList.retrieveLastElement());
		assertEquals("Xaviersobased", basicList.retrieveLastElement());
		assertEquals("Osamason", basicList.retrieveLastElement());
		assertEquals("Nettspend", basicList.retrieveLastElement());
		assertEquals(null, basicList.retrieveLastElement());
	}

	@Test
	void testToArrayList() {
		basicList.addToFront("Revived");
		basicList.addToFront("Devotion");
		basicList.addToEnd("Nothing More Nothing Less");
		basicList.addToFront("Fallen Raven");
		basicList.addToEnd("What We Didn't Have");
		
		ArrayList<String> arrList = new ArrayList<>();
		arrList = basicList.toArrayList();
		
		assertEquals("Fallen Raven", arrList.get(0));
		assertEquals("Devotion", arrList.get(1));
		assertEquals("Revived", arrList.get(2));
		assertEquals("Nothing More Nothing Less", arrList.get(3));
		assertEquals("What We Didn't Have", arrList.get(4));

	}
	
	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}

	}

}
