import java.util.*;
class GetSingleChar{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Set<Character> ch = new HashSet<>();
//		while(in.hasNext()){
			String str = in.next();
			System.out.println(str);
			for(int i = 0;i < str.length(); i++){
				ch.add(str.charAt(i));
			
			}	
		
//		}

		System.out.println(ch);
		System.out.println(ch.size());
	
	
	
	
	}



}
