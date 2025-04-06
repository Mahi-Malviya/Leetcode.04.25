class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int maxsum =Integer.MIN_VALUE;
        for (int i=0;i<nums.length; i++){
            if(sum <0){
                sum = 0;
            }
            sum= sum + nums[i];
            maxsum = Math.max(sum,maxsum);
  } 
        return maxsum;
    }
}