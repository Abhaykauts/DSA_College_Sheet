class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i:nums){
            temp.add(i);
        }
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int i : nums) {
        //     map.put(i, 0);
        // }
        // permutations(nums, result, temp, map);

        permutations(temp,result,0);
        return result;
    }

    // private void permutations(int[] nums, List<List<Integer>> result, List<Integer> temp,
    //         HashMap<Integer, Integer> map) {
    //     if (temp.size() == nums.length) {
    //         result.add(new ArrayList<>(temp));
    //         return;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (map.get(nums[i]) == 0) {
    //             temp.add(nums[i]);
    //             map.put(nums[i], 1);
    //             permutations(nums, result, temp, map);
    //             map.put(nums[i], 0);
    //             temp.remove(temp.size() - 1);
    //         }
    //     }

    private void permutations(List<Integer> temp,List<List<Integer>> result,int index  ){
        if(index==temp.size()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<temp.size();i++){
            swap(i,index,temp);
            permutations(temp,result,index+1);
            swap(i,index,temp);
        }
    }

    private void swap(int a,int b,List<Integer> list){
        int temp=list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
        
    }
}