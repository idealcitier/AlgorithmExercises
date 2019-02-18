class Solution{
	public static int[] twoSum(int[] nums, int target){
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] == target - nums[i]){
					return new int[]{i,j};
				
				}

			}
		
		}
		// 这里必须有返回值，若不存在结果，可以返回一个空的数组，也可以直接抛出一个异常
		return new int[0];

		// throw new IllegalArgumentException("No two num solution");	
	}


	public static void main(String args[]){
		int[] nums = {2,7,11,15};
		int target = 9;
		Solution s = new Solution();
		int[] result = s.twoSum(nums, target);
		System.out.println(result[0] + "," + result[1]);
	
	}

}
