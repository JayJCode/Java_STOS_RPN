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
	public void testPeek() {
		Stack stack = new Stack();
		stack.push("kot, razem z ala");
		String result = stack.peek();

		assertEquals("peek after push", "kot, razem z ala", result);
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
	
	@Test
	public void RPN1() {
		Stack stack = new Stack();
		stack.push("+");
		stack.push("3");
		stack.push("2");
		String result = stack.RPN();

		assertEquals("RPN 2+3", "5", result);
	}
	
	@Test
	public void RPN2() {
		Stack stack = new Stack();
		stack.push("/");
		stack.push("3");
		stack.push("+");
		stack.push("7");
		stack.push("2");
		String result = stack.RPN();

		assertEquals("RPN (2+7)/3", "3", result);
	}
	
	@Test
	public void RPN3() {
		Stack stack = new Stack();
		stack.push("-");
		stack.push("3");
		stack.push("+");
		stack.push("*");
		stack.push("4");
		stack.push("+");
		stack.push("2");
		stack.push("1");
		stack.push("5");
		String result = stack.RPN();

		assertEquals("RPN 5+(1+2)*4−3", "14", result);
	}
	
	@Test
	public void RPN4() {
		Stack stack = new Stack();
		stack.push("+");
		stack.push("*");
		stack.push("+");
		stack.push("/");
		stack.push("5");
		stack.push("10");
		stack.push("*");
		stack.push("4");
		stack.push("3");
		stack.push("2");
		stack.push("12");
		String result = stack.RPN();

		assertEquals("RPN 12+2×(3×4+10/5)", "40", result);
	}
}
