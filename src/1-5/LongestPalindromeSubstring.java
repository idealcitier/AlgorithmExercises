public class LongestPalindromeSubstring{
	public static void main(String[] args){
	
	}

	public static boolean isPalindromic(String str){

		String reverse = new StringBuffer(str).reverse().toString();

		if(str.equals(reverse)){
			return true;
		}else{
			return false;
		}
	}

	public static String[] getSubstring(String str){
		
	}



}
