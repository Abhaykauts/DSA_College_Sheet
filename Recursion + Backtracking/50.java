class Solution {
    public double myPow(double x, int n) {
        //recursive code
        double N=n;
        if(N<0){
            N=-N;
            x=1/x;
        }

        return Pow(x,N);
    }

    private double Pow(double x,double n){
        if(n==0) return 1.0;

        else if(n%2==0){
            return Pow(x*x,n/2);
        }

        else{
            return x*Pow(x,n-1);
        }
    }
}