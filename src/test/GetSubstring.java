import java.util.*;

class GetSubstring{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		//String str = "pwwkew";
		//System.out.println(str);
		int len = 0;
		//System.out.println("-------------");
		for(int i = 0; i < str.length(); i++){
			for (int j = i+1; j<=str.length(); j++){
		//		System.out.println(str.substring(i,j));
				if(unique(str.substring(i,j))){
					if(str.substring(i,j).length() > len )

						len = str.substring(i,j).length(); 
				}
			}
		}
		System.out.println(len);

	}
	
	public static boolean unique(String str){
		Set<Character> set= new HashSet<>();

		for(int i = 0; i<str.length();i++){
			char ch = str.charAt(i);

			if( set.contains(ch) ){
				return false;
			}
			set.add(ch);
				
		}
		return true;
	}
	
}

