class Solution{
	public int lengthOfLongestSubstring(String s){
		// get substring
		// judge the substring 
		int count  =0;
		for(int i = 0;i < s.length();i++){
			for(int j = i+1;j < s.length()+1;j++){
				String subStr = s.substring(i,j);
				// System.out.println(subStr);
				// subStrLength = subStr.length();
				if(isUnqiue(subStr)){
					if(subStr.length() > count){
						count = subStr.length();

					}
				}
			}
		}
		return count;

	}
	public boolean isUnqiue(String s){
		for(int i = 0;i<s.length()-1;i++){
			for(int j = i+1;j<s.length();j++)
			if(s.charAt(i) == s.charAt(j)){
				return false;
			}
		}
		return true;
	}



	public static void main(String args[]){
		System.out.println("hello world");
		String s = "bbbbbbbbbb";
		Solution so = new Solution();
		int cnt = so.lengthOfLongestSubstring(s);
		System.out.println(cnt);
		// boolean flag = so.isUnqiue(s);
		// if(flag){
		// 	System.out.println("true");
		// }else{
		// 	System.out.println("false");
		// }
	}

}
