class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nsl = NSL(arr);
        int[] nsr = NSR(arr);
        int MOD = 1_000_000_007;
        long result = 0;

        for(int i=0;i<arr.length;i++){
            long left = (i - nsl[i]);
            long right = (nsr[i] - i);

            result += (((left * right) % MOD)*arr[i])% MOD;
        }

        return (int)(result % MOD);
    }

    private int[] NSL(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for(int i=0;i<result.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    private int[] NSR(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = n;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}