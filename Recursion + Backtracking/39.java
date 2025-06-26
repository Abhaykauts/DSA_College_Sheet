class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        combinations(candidates,target,result,temp,0,0);
        return result;
    }

    private void combinations(int[]candidates,int target,List<List<Integer>> result,List<Integer> temp,int sum,int index){
        if(sum>target){
            return;
        }
        if(sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            sum+=candidates[i];
            temp.add(candidates[i]);
            combinations(candidates,target,result,temp,sum,i);
            sum-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}