class Solution {
    
    int[][] dp;
    
    public int f(int a,int b,int m,int n){
        if(dp[a][b]!=-1){
            return dp[a][b];
        }
        if(a==m-1 && b==n-1){
            dp[a][b] = 0;
        }
        
        if(a==m-1 || b==n-1){
            dp[a][b] = 1;
        }
        
        if(a<m-1 && b<n-1){
            dp[a][b] = f(a,b+1,m,n) + f(a+1,b,m,n);
        }
        return dp[a][b];
    }
    
    public int numberOfPaths(int m, int n) {
        // Code Here
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
          return f(0,0,m,n);
    }
}