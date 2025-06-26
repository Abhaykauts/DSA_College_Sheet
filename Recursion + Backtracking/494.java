class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> dp = new HashMap<>();
       return targetSum(nums,target,0,0,dp);
    }

    private int targetSum(int[]nums,int target,int sum,int index,HashMap<String,Integer> dp ){
        if(index==nums.length){
            if(sum==target) return 1;
            return 0;
        }

        String s = index+","+sum;

        if(dp.containsKey(s)) return dp.get(s);
        
        int add=targetSum(nums,target,sum+nums[index],index+1,dp);
        int sub=targetSum(nums,target,sum-nums[index],index+1,dp);
        dp.put(s,add+sub);
        return add+sub;
    }
}