class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>dict = new HashSet<String>();
        for(String str:wordDict){
            dict.add(str);
        }
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n+1;j++){
                String rv = s.substring(i,j);
                if(dict.contains(rv)){
                    dp[i] = dp[i]||dp[j];
                }
            }
        }
        return dp[0];
    }
}
