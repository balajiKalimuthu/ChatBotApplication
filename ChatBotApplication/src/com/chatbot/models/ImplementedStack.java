package com.chatbot.models;

import java.util.Stack;

public class ImplementedStack {
	private static ImplementedStack implementedStack;
	private static Stack<Character> stack;

	private ImplementedStack() {
	}

	public static ImplementedStack getInstance() {
		if (implementedStack == null) {
			implementedStack = new ImplementedStack();
			stack = new Stack<Character>();
		}
		return implementedStack;
	}

	public void pushData(char choice) {
		stack.push(choice);
	}

	public void popData() {
		stack.pop();
	}

	public char peekData() {
		return stack.peek();
	}

	public boolean isEmptyData() {
		return stack.isEmpty();
	}
}