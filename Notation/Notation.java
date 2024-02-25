
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
				stack.push(Character.toString(c));
				while ((stack.top() == "+" || stack.top() == "-" || stack.top() == "/" || stack.top() == "*") && !stack.isEmpty()) {
					queue.enqueue(stack.pop());
				}
			} else if (c == '*' || c == '/') {
				stack.push(Character.toString(c));
				while ((stack.top() == "/" || stack.top() == "*") && !stack.isEmpty()) {
					queue.enqueue(stack.pop());
				}
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
				String tempRight = stack.pop();
				String tempLeft = stack.pop();
				String operation = "" + '(' + tempLeft + c + tempRight + ')';
				stack.push(operation);
			}
		}
		return stack.pop();
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>();
		
		for (int i = 0; i < postfixExpr.length(); i++) {
			char c = postfixExpr.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(Double.parseDouble("" + c));
			} else if (isOperator(c)) {
				double tempRight = stack.pop();
				double tempLeft = stack.pop();
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
		
		return stack.pop();
	}
	
	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		} else {
			return false;
		}
	}
}
