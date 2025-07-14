class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] result = new int[]{-1,-1};
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             result[0]=i;
        //             result[1]=j;
        //             return result;
        //         }
        //     }
        // }
        HashMap<Integer,Integer> map = new HashMap<>();
        int value=0;
        for(int i=0;i<n;i++){
            value=target-nums[i];
            if(map.containsKey(value)){
                result[0]=i;
                result[1]=map.get(value);
                return result;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}