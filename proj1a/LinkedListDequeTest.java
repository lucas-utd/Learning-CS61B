import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		/*
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
		*/
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		/*
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
		*/
	}

	@Test
	public void printDequeTest() {
		LinkedListDeque<Integer> deque = LinkedListDeque.of(4, 2, 3);
		assert deque != null;
		assertEquals("4 2 3", deque.printDeque());
	}

	@Test
	public void ofTest() {
		LinkedListDeque<Integer> deque = LinkedListDeque.of();
		assertNull(deque);

		LinkedListDeque<Integer> deque1 = LinkedListDeque.of(1, 2, 3);
		assertNotNull(deque1);
		assertEquals("1 2 3", deque1.printDeque());
	}

	@Test
	public void addFirstTest() {
		LinkedListDeque<Integer> deque = new LinkedListDeque<>();
		deque.addFirst(1);
		deque.addFirst(2);
		assertEquals("2 1", deque.printDeque());
	}

	@Test
	public void addLastTest() {
		LinkedListDeque<Integer> deque = new LinkedListDeque<>();
		deque.addLast(1);
		deque.addLast(2);
		deque.addLast(3);
		assertEquals("1 2 3", deque.printDeque());
	}

	@Test
	public void isEmptyTest() {
		LinkedListDeque<Integer> deque = new LinkedListDeque<>();
		assertTrue(deque.isEmpty());

		deque.addFirst(1);
		assertFalse(deque.isEmpty());

		LinkedListDeque<Integer> deque1 = LinkedListDeque.of(1, 2, 3);
		assert deque1 != null;
		assertFalse(deque1.isEmpty());
	}

	@Test
	public void removeFirstTest() {
		LinkedListDeque<Integer> deque = new LinkedListDeque<>();
		assertNull(deque.removeFirst());

		deque.addFirst(1);
		assertEquals(Integer.valueOf(1), deque.removeFirst());

		LinkedListDeque<Integer> deque1 = LinkedListDeque.of(3, 2, 1);
		assert deque1 != null;
		assertEquals(Integer.valueOf(3), deque1.removeFirst());
		assertEquals("2 1", deque1.printDeque());
		assertEquals(2, deque1.size());
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 