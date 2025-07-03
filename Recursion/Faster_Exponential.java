class Solution {
      
      public double myPow(double x, long n){
        if(n<0){
            return 1/myPow(x, -1*n);
        }
        if(n==0){
            return 1.0;
        }

        double half = myPow(x,n/2);
        return (n%2==0)?(half*half):(half*half*x);
      }
     

    public double myPow(double x, int n) {
        return myPow(x,(long)n);
    }
}