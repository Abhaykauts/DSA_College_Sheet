class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey(sum-goal)){
                count+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}