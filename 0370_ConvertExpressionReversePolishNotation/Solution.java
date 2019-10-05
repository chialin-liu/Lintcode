public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public List<String> convertToRPN(String[] expression) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(expression == null || expression.length == 0) return res;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < expression.length; i++){
            String str = expression[i];
            if(str.equals("(")){
                stack.push(expression[i]);
            }
            else if(Character.isDigit(str.charAt(0))){
                res.add(str);
            }
            else if(str.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    res.add(stack.pop());
                }
                stack.pop();
            }
            else{
                int priority = getPriority(str);
                int priority_stack = stack.isEmpty()? 0 : getPriority(stack.peek());
                while(!stack.isEmpty() && priority_stack >= priority){
                    res.add(stack.pop());
                    priority_stack = stack.isEmpty()? 0 : getPriority(stack.peek());
                }
                stack.push(str);
            }
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    public int getPriority(String str){
        if(str.equals("*") || str.equals("/")){
            return 3;
        }
        else if(str.equals("+") || str.equals("-")){
            return 2;
        }
        else{
            return 1;
        }
    }
}
