class TwoNum{
	public static void main(String[] args){
	
		int[] nums = {2, 7, 11, 15};
		System.out.println(nums.length);
			

		for(int i = 0;i<nums.length-1;i++){
			for(int j = i+1; j<nums.length; j++){
			
				if(nums[i] + nums[j] == 17){
					
					int result[] = {i,j};
				
					System.out.println(i + "," + j);
				
				
				}
			
			
			}
		
		
		}
	
	
	
	}

//	public int[] findNum(int[] nums, int target){
		
	
	
//	}


}
