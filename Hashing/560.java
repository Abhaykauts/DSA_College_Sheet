class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        
        // for(int i=0;i<nums.length;i++){
        //     int sum=nums[i];
        //     if(nums[i]==k){
        //         count+=1;
        //     }
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[j]+sum==k){
        //             count+=1;
        //         }
        //         sum+=nums[j];
        //     }
        // }
        // return count;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
        
}