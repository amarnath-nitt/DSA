package main.datastructures.stack;

import java.util.Stack;

/**
 * @author amarnath-nitt 12/05/23
 */
public class CheckBalancedParenthesis {
    public static void main(String[] args) {
        String str = "(]";
        if(checkBalancedParenthesis(str)){
            System.out.println("Parenthesis are balanced.");
        }
        else{
            System.out.println("Parenthesis are not balanced");
        }
    }

    private static boolean checkBalancedParenthesis(String str) {
        Stack<Character> st = new Stack();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.add(ch);
            }
            else if( !st.isEmpty() && ((ch == ')' && st.peek() == '(') ||  (ch == '}' && st.peek() == '{')  || (ch == ']' && st.peek() == '['))){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
}
