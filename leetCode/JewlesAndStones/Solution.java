class Solution {
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for(int s = 0; s < S.length(); s++){
            for(int j = 0;j < J.length();j++){
                if(S.charAt(s) == J.charAt(j)){
                    num++;
                }
            }

        }
        return num;
    }
}