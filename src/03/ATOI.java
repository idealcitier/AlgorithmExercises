import java.util.Scanner;

public class ATOI{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(strToInt(str)+1);
	
	}
	public static int strToInt(String str){
		char[] ch = str.toCharArray();
		int num=0;
		for(int i=0;i < ch.length;i++){
			int tmp = ch[i] - '0';
			num = num * 10 + tmp;
		}
		return num;	
	
	}
}
