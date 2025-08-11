class Solution {
    public double pospow(double x,int n){
        if(n<=1){
            return x;
        }
        double a = pospow(x,n/2);
        if(n%2==0){
            return a*a;
        }
        return pospow(x,n/2+1)*a;
    }
    public double myPow(double x, int n) {
        if(x==-1){
            if(n%2==0) return 1;
            return -1;
        }
        if(n==0||x==1) return 1;
        if(n==Integer.MIN_VALUE){
            x =0;
            return x;
        }
        if(n>=0){
            return pospow(x,n);
        }
        double r = 1/x;
        n*=-1;
        return pospow(r,n);
    }
}