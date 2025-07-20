import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack_string = new Stack<>();
        Stack<Integer> stack_int = new Stack<>();
        int num = 0;  // to accumulate multi-digit numbers

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build multi-digit number like "23"
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current number and reset num
                stack_int.push(num);
                num = 0;
                stack_string.push("[");
            } else if (ch == ']') {
                // Build the string to repeat
                StringBuilder tempStr = new StringBuilder();
                while (!stack_string.isEmpty() && !stack_string.peek().equals("[")) {
                    tempStr.insert(0, stack_string.pop());
                }

                // Pop the '['
                if (!stack_string.isEmpty() && stack_string.peek().equals("[")) {
                    stack_string.pop();
                }

                // Repeat the string
                int repeatCount = stack_int.pop();
                StringBuilder repeated = new StringBuilder();
                for (int i = 0; i < repeatCount; i++) {
                    repeated.append(tempStr);
                }

                // Push repeated string back to stack
                stack_string.push(repeated.toString());
            } else {
                // Just a character, push as string
                stack_string.push(Character.toString(ch));
            }
        }

        // Final result by combining all strings in stack
        StringBuilder result = new StringBuilder();
        for (String str : stack_string) {
            result.append(str);
        }

        return result.toString();
    }
}
