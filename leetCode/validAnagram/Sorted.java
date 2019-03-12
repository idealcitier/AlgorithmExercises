import java.util.*;
class Sorted{
    public static void main(String[] args) {
        String str = new String("anagram");
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for (char var : arr) {
            System.out.println(var);
            
        }    
    }


}