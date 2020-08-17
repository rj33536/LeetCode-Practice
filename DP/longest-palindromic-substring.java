class Solution {

    public String longestPalindrome(String s) {
        int n = s.length(), count = 0;
        int[][] dp = new int[n][n];
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    if (ans.length() < (i - j + 1)) {
                        ans = s.substring(j, i + 1);
                    }
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j + 1) {
                        dp[i][j] = 1;
                        if (ans.length() < (i - j + 1)) {
                            ans = s.substring(j, i + 1);
                        }
                        continue;
                    }

                    if (dp[i - 1][j + 1] == 1) {
                        if (ans.length() < (i - j + 1)) {
                            ans = s.substring(j, i + 1);
                        }
                        dp[i][j] = 1;
                        continue;
                    }
                }

            }
        }
        return ans;

    }
}
