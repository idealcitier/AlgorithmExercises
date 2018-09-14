import java.util.Scanner;

class NextLine{
	public static void main(String[] args){
		Scanner sc = new Scanner(" aksjdsa    sd \n asdsads");
		
		while(sc.hasNextLine()){
			String content = sc.nextLine();
			System.out.println(content);
		}
		
	}
}

