package Stack;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class StackTest {
	@Test
	public void testPopAfterPush() {
		Stack stack = new Stack();
		stack.push("napis");
		String result = stack.pop();

		assertEquals("pop after push", "napis", result);
	}
	
	@Test
	public void testPushx2Popx2() {
		Stack stack = new Stack();
		stack.push("Jestem pierwszym tekstem");
		stack.push("a ja drugim.");
		String result = stack.pop();
		result = stack.pop();

		assertEquals("pushx2", "Jestem pierwszym tekstem", result);
	}
	
	@Test
	public void testPeekNothing() {
		Stack stack = new Stack();
		String result = stack.peek();

		assertEquals("peek from nothing", "Stos jest pusty :)", result);
	}
	
	@Test
	public void testPopNothing() {
		Stack stack = new Stack();
		stack.push("Długi tekst, nudny jak flaki z olejem.  :) Długi tekst, nudny jak flaki z olejem.  :) Długi tekst, nudny jak flaki z olejem.  :)");
		String result = stack.pop();
		result = stack.pop();

		assertEquals("pop from nothing", "Stos jest pusty :)", result);
	}
	
	@Test
	public void testPeekx2() {
		Stack stack = new Stack();
		stack.push("2 razy wywołąny peek mnie nie usunię!");
		String result = stack.peek();
		result = stack.peek();

		assertEquals("peek after push", "2 razy wywołąny peek mnie nie usunię!", result);
	}
}
