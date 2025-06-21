class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        // int result=0;
        // for(int i=0;i<nums.length;i++){
        //     result^=nums[i];
        // }
        // return result;

        //check here for the two edge cases , two extreme indexes

        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int start = 1;
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            else if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}