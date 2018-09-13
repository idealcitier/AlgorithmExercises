import java.util.Scanner;
public class ContainString{

	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		String str1 = "ABCD";
		String str2 = "BFD";
		if(containString(str1, str2)){
			System.out.println("contain");
		}
		else{
			
			System.out.println("not contain");
		}
	}

	public static boolean containString(String str1, String str2){
		
		char[] lon;
		char[] sht;

		if(str1.length() > str2.length()){
			lon = str1.toCharArray();
			sht = str2.toCharArray();
		}
		else{
			lon = str2.toCharArray();
			sht = str1.toCharArray();
		}
		for(int i = 0; i < sht.length; i++){
			int flag = 0;
			for(int j=0; j < lon.length; j++){
				if( sht[i] == lon[j] ){
					continue;
				}else{
					flag++;
				}
				if(flag >= lon.length){
					return false;
				}
			}
		}
		return true;
	}
}
