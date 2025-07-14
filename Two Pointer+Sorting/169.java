class Solution {
    public int majorityElement(int[] nums) {
        //Hashing Approach
        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i:nums){
        //     map.put(i,map.getOrDefault(i,0)+1);
        //     if(map.get(i)>nums.length/2)
        //     return i;
        // }
        // return 0;

        //Moore's Algo

        int value=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if(value!=nums[i]){
                count--;
                if(count==0){
                    value=nums[i];
                    count=1;
                }
            }
            else{
                count++;
            }
        }

        return value;
    }
}