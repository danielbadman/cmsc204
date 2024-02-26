
public class Notation {
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		MyStack<String> stack = new MyStack<>();
		MyQueue<String> queue = new MyQueue<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isDigit(c)) {
				queue.enqueue(Character.toString(c));
			} else if (c == '('){
				stack.push(Character.toString(c));
			} else if (c == '+' || c == '-') {
				while (!stack.isEmpty() && (stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("/") || stack.top().equals("*"))) {
					queue.enqueue(stack.pop());
				}
				stack.push(Character.toString(c));
			} else if (c == '*' || c == '/') {
				while (!stack.isEmpty() && (stack.top().equals("/") || stack.top().equals("*"))) {
					queue.enqueue(stack.pop());
				}
				stack.push(Character.toString(c));
			} else if (c == ')') {
				while (!stack.top().equals("(")) {
					queue.enqueue(stack.pop());
					if (stack.isEmpty()) {
						throw new InvalidNotationFormatException();
					}
				}
				stack.pop();
			}
		}
		
		while (!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		
		String result = "";
		while (!queue.isEmpty()) {
			result += queue.dequeue();
		}
		return result;
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<>();
		for (int i = 0; i < postfix.length(); i++) {
			Character c = postfix.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(c.toString());
			} else if (isOperator(c)) {
				String tempRight = "";
				String tempLeft = "";
				try {
					tempRight = stack.pop();
					tempLeft = stack.pop();
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				String operation = "" + '(' + tempLeft + c + tempRight + ')';
				stack.push(operation);
			}
		}

		String answer;
		try {
			answer = stack.pop();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		
		if (!stack.isEmpty()) {
			throw new InvalidNotationFormatException();
		} else {
			return answer;
		}
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>();
		
		for (int i = 0; i < postfixExpr.length(); i++) {
			char c = postfixExpr.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(Double.parseDouble("" + c));
			} else if (isOperator(c)) {
				double tempRight = 0;
				double tempLeft = 0;
				try {
					tempRight = stack.pop();
					tempLeft = stack.pop();
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				double result = 0;
				switch (c) {
				case '+' -> result = tempLeft + tempRight;
				case '-' -> result = tempLeft - tempRight;
				case '*' -> result = tempLeft * tempRight;
				case '/' -> result = tempLeft / tempRight;
				}
				stack.push(result);
			}
		}
		
		Double answer;
		try {
			answer = stack.pop();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		
		if (!stack.isEmpty()) {
			throw new InvalidNotationFormatException();
		} else {
			return answer;
		}
	}
	
	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		} else {
			return false;
		}
	}
}
