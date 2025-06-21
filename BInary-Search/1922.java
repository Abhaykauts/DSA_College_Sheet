class Solution {
    static long M=1_000_000_007;
    public int countGoodNumbers(long n) {
        return (int) (Pow(5,(n+1)/2)*Pow(4,n/2)%M);
    }

    private long Pow(long x,long n){
        if(n==0) return 1;

        if(n%2==0){
            return Pow((x*x)%M,n/2)%M;
        }

        else{
            return x*Pow(x,n-1)%M;
        }
    }
}