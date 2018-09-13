import java.util.Scanner;

public class ReverseSentence{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String out = reverseSentence(str);
		System.out.println(out);
		
	}

	public static String reverseSentence(String str){
		if(str == null) {return null;}
		if(str.trim().equals("")){
			return str;
		}
		String[] strs = str.split(" ");
		StringBuffer buff = new StringBuffer();
		for(int i = strs.length-1; i >= 0; i--)	{
			if(i==0){
				buff.append(strs[i]);
			}else{
				buff.append(strs[i]);
				buff.append(" ");
			
			}
		}
		String reverse = buff.toString();
		return reverse;


	}




}
