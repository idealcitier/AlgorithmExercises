// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// ascii
// (  40  
// )  41  
// [  91  
// ]  93  
// {  123 
// }  125 
// 通过ASCII可以看出，各个符号的ASCII差值相近，利用他们直接的差值进行判断
// 遇到左括号进栈
// 遇到右括号出站
// 如果栈为空，return false
// 如果出栈的元素不是匹配的括号，return false
import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return false;
        Stack<Character> stack = new Stack<Character>(); // 创建堆栈对象 
        for(int i = 0;i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
            {
                if(stack.empty()) return false;
                char out = stack.pop();
                if((out - s.charAt(i)) > 2 || (out - s.charAt(i)) < -2)
                    return false;
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
    public static void main(String args[]){
        Solution S = new Solution();
        String s = "(]";
        System.out.println(S.isValid(s));
        
    }
}
