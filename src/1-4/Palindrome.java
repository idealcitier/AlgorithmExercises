import java.util.Scanner;

public class Palindrome{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
	
		if(isPalindrome(str)){
			System.out.println( "is palindrime" );
		}else{
		
			System.out.println( "is not  palindrime" );
		}
	}
	public static boolean isPalindrome(String str){
		String strReverse = new StringBuffer(str).reverse().toString();

		if(str.equals(strReverse)){
			return true;
		}
		else{
			return false;
		}

	}

}
