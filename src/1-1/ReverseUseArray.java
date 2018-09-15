import java.util.Scanner;

public class ReverseUseArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String out = reverse(str);
		System.out.println(out);
	}

	public static String reverse(String str){
		char[] ch = str.toCharArray();
		String reverse = "";
		for( int i = ch.length - 1; i >= 0; i--){
			reverse += ch[i];
		}
		return reverse;
	}

}
