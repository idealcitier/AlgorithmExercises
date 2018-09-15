import java.util.Scanner;

public class Reverse{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String out = new StringBuffer(str).reverse().toString();
		System.out.println(out);
		
	}

}
