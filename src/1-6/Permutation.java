import java.util.*;
import java.lang.String;
public class Permutation{
	public static void main(String[] main){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] ch = str.toCharArray();
		int begin = 0;
		int end = ch.length;
		permutation(ch, begin,end);
		
//		for (char[]  )

//		System.out.println()
	
	}

	public static void permutation(char[] s, int from ,int to){
		if(to <= 0){
			return ;
		}
		if( from == to ){
			System.out.println(s);
		}else{
			for( int i = from;i < to;i++ ){
				swap(s, i, from);
				permutation(s, from+1, to);
				swap(s, from, i);
			
			}
		}

	
	}
	
	public static void swap(char[] s, int i, int j){
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
}
