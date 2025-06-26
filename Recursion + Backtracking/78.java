class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // List<Integer> temp = new ArrayList<>();
        // List<List<Integer>> result= new ArrayList<>();
        //  subset(nums,0,result,temp);
        //  return result;

        return subset(nums);
    }

    // private void subset(int[]nums,int i,List<List<Integer>> result,List<Integer>temp){
    //     if(i==nums.length){
    //         result.add(new ArrayList<>(temp));
    //         return;
    //     }

    //     temp.add(nums[i]);
    //     subset(nums,i+1,result,temp);
    //     temp.remove(temp.size()-1);
    //     subset(nums,i+1,result,temp);
    // }


    private List<List<Integer>> subset(int[]nums){
        int n=nums.length;
        int totalSubs = (1<<n);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<totalSubs;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}