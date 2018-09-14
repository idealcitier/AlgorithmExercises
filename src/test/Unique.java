import java.util.*;

class Unique{
	public static void main(String[] args){
		String str = "abbs";
		Set<Character> set = new HashSet<>();

		for(int i = 0; i<str.length();i++){
			char ch = str.charAt(i);

			if( set.contains(ch) ){
				System.out.println("the set contain the ch");
				System.exit(0);
			}
			set.add(ch);
				
		}
		System.out.println(" str is unique ");
		
							
	

	}

}
