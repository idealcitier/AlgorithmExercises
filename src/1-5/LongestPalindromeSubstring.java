import java.util.*;
public class LongestPalindromeSubstring{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Set<String> set = new HashSet<>();
		set = getSubstring(str);
		Iterator it = set.iterator();
		int len = 0;
		String longestPalindromeSubstring = "";
		while(it.hasNext()){
			String  substring = (String)it.next();
			//System.out.println(substring);
			if(isPalindromic(substring)){
				if(substring.length() > len){
					len = substring.length();
					longestPalindromeSubstring = substring;
	
				}else{
					continue;
				}
			}

		}

		System.out.println("longestPalindromeSubstring= " + longestPalindromeSubstring );
		System.out.println("len = " + len);
	}

	public static boolean isPalindromic(String str){

		String reverse = new StringBuffer(str).reverse().toString();

		if(str.equals(reverse)){
			return true;
		}else{
			return false;
		}
	}

	public static Set<String> getSubstring(String str){
		Set<String> set = new HashSet<>();
		for(int i = 0;i<str.length();i++){
			for (int j = i+1;j < str.length()+1;j++)
				set.add(str.substring(i,j));
		}
		
		return set;
	}



}
