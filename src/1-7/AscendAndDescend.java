import java.util.*;
public class AscendAndDescend {
	public static void main(String[] args) {
		int[] arr = { 45, 63, 8, 7, 6, 4, 2, 3, 1, 88 };
		List<Integer> list = new ArrayList<>();
		int a = 10;
		int b = 5;
		list = ascendAndDescend(a, b , arr)	;
	
	}

	public static List<Integer> ascendAndDescend(int num, int random, int[] sticks){
		int[] a  = Arrays.copyOfRange(sticks,0,random);

		int[] b = Arrays.copyOfRange(sticks,random,num);
		List<Integer> list = new ArrayList<>();
		Arrays.sort(a);
		for (int i : a) {
			System.out.print(i + " ");
			list.add(i);
		}
 
		for (int i = 0; i < b.length - 1; i++) {
			for (int j = 0; j < b.length - 1 - i; j++) {
				if (b[j] < b[j + 1]) {
					int temp = b[j];
					b[j] = b[j + 1];
					b[j + 1] = temp;
				}
			}
		}
		for (int i : b) {
			System.out.print(i + " ");
			list.add(i);
		}
		return list;
	

	
	
	}



}
