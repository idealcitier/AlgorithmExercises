import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        if(Arrays.equals(sArr, tArr)){
            return true;
        }else{
            return false;
        }
    }
}