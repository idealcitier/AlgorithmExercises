import java.util.Scanner;

public class PalindromeNum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int num = Integer.valueOf(str);
	
		if(isPalindromeNum(num)){
			System.out.println( "is palindrime" );
		}else{
		
			System.out.println( "is not  palindrime" );
		}
	}
	public static boolean isPalindromeNum(int num){
		int a = num,r = 0;

		if(num < 0) return false;

		while( a>0 ){
			r = r * 10 + a%10;
			a = a / 10;
		
		}
		
		if ( r == num ) {
			return true;
		}else{
			return false;
		}


	}

}
