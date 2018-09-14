class Remainder{
	public static void main(String[] args){
		int val = -1230;
		int rev = 0, pop = 0;
		while(val!=0){
		    pop = val % 10;
			val = val/10;

			System.out.println(Integer.MAX_VALUE);
			if(rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7){ System.out.println("The input is too big"); }

			if(rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8){ System.out.println("The input is too small"); }



			rev = rev * 10 + pop;
		}


		System.out.println(rev);

		System.out.println(Integer.MIN_VALUE);
	}


}
