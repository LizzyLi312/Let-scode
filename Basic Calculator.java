class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        stack.push(0);
        signStack.push(1);
        for(int i = 0; i <= s.length(); i++){
            char c = i < s.length() ? s.charAt(i) : '+';
            if(c <= '9' && c >= '0'){
                int num = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num * 10 + s.charAt(i++) - '0';
                }
                i--;
                stack.push(num);
            }
            else if(c == '('){
                stack.push(0);
                signStack.push(1);
            }
            else if(c == '+' || c == '-' || c == ')'){ //calculate numbers when we meet these operators
                int top = stack.pop(); //the first element would be add with 0.
                int sign = signStack.pop();
                stack.push(stack.pop() + top * sign);
                if(c == '+') signStack.push(1);
                if(c == '-') signStack.push(-1);
            }
            else continue;
        }
        return stack.pop(); //the result is the last element in the stack
    }
}
