import java.util.Scanner;

public class Atoi1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(strToInt(str)+1);
	
	}
	public static int strToInt(String str){
		if(str == null || str.equals(""))
			return 0;
		str = str.trim();
		int i = 0;
		char flag = '+';
		char[] ch = str.toCharArray();
		if(ch[i] == '-'){
			flag = '-';
			i++;
		}else if(ch[i] == '+'){
			flag = '+';
			i++;
		}
		int num = 0;
		int tmp = 0;
		while(i < ch.length ){
			if( ch[i] <= '9' && ch[i] >= '0' ){
				tmp = ch[i] - '0';
				num = num * 10 + tmp;
				i++;
			}else{
				return 0;
			}


		}

		if(flag == '-'){
			num = -num;
		}
		if(num > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		else if(num < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}else{
			return num;
		}

		
	
	}
}
