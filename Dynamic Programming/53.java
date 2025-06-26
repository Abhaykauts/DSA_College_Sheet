class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum+=nums[i];
            if(currSum<0){
                maxSum=Math.max(maxSum,currSum);
                currSum=0;
            }
            else{
                maxSum=Math.max(maxSum,currSum);
            }
            
        }
        return maxSum;
    }
}