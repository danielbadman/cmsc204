
/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedListTest_STUDENT {

	SortedDoubleLinkedList<String> sortedList;
	
	@BeforeEach
	void setUp() throws Exception {
		sortedList = new SortedDoubleLinkedList<String>(new StringComparator());
	}

	@AfterEach
	void tearDown() throws Exception {
		sortedList = null;
	}

	@Test
	void testIterator() {
		sortedList.add("Adam");
		sortedList.add("Flynn");
		sortedList.add("Eric");
		sortedList.add("Yvon");
		sortedList.add("Jasmine");
		
		ListIterator iter = sortedList.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals("Adam", iter.next());
		assertEquals("Eric", iter.next());
		assertEquals("Flynn", iter.next());
		assertEquals("Jasmine", iter.next());
		assertEquals("Yvon", iter.next());
		assertFalse(iter.hasNext());
		assertEquals("Jasmine", iter.previous());
		assertEquals("Flynn", iter.previous());
		assertEquals("Eric", iter.previous());
		assertEquals("Adam", iter.previous());
		assertFalse(iter.hasPrevious());
	}

	@Test
	void testRemove() {
		sortedList.add("J Cole");
		sortedList.add("Kendrick Lamar");
		sortedList.add("Kanye West");
		sortedList.add("Earl Sweatshirt");
		
		assertEquals("Kanye West", sortedList.remove("Kanye West", new StringComparator()).data);
		assertEquals(3, sortedList.getSize());
	}

	@Test
	void testAdd() {
		sortedList.add("Icedancer");
		sortedList.add("Red Light");
		sortedList.add("Gluee");
		sortedList.add("Crest");
		
		assertEquals(4, sortedList.getSize());
		ArrayList<String> arrList = sortedList.toArrayList();
		
		assertEquals("Crest", arrList.get(0));
		assertEquals("Gluee", arrList.get(1));
		assertEquals("Icedancer", arrList.get(2));
		assertEquals("Red Light", arrList.get(3));
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}

	}
}
