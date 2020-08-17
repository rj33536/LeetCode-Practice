class Solution {
    public int countSubstrings(String s) {
        int n = s.length(),count=0;
        int[][]dp = new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[i][i] = 1;
            for(int j=0;j<=i;j++){
                if(i==j){
                    dp[i][j] = 1;
                    count++;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(i==j+1){
                        dp[i][j] = 1;
                        count++;
                        continue;
                    }
                    
                    if(dp[i-1][j+1]==1){
                    count++;
                    dp[i][j] = 1;
                        continue;
                }
                }
                
            }
        }
        return count;
    }
}
