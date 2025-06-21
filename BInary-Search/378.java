class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        //Max-Heap approach
        // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         queue.offer(matrix[i][j]);
        //         if(queue.size()>k){
        //             queue.poll();
        //         }
        //     }
        // }

        // return queue.poll();


        //Binary Search Approach

        int start=matrix[0][0];
        int end=matrix[n-1][n-1];

        while(start<=end){
            int mid=start+(end-start)/2;
            //Now calculate all the numbers in the matrix that are smaller than this mid.

            int count=0;
            for(int i=0,j=n-1;i<n;i++){
                //remove all greater numbers from this row
                while(j>=0&&matrix[i][j]>mid){
                    j--;
                }

                if(j>=0){
                    count+=j+1;
                }
                else{
                    break;//that means no smaller elements in this row , check for next row.
                }
            }

            if(count>=k){
                end=mid-1;//search for more numbers on the left.
            }
            else{
                start=mid+1;//increase the mid.
            }
        }

        return start;
    }
}

