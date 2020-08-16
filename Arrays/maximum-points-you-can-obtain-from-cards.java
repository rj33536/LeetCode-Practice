class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[]prefix = new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+cardPoints[i];
        }
        int total = prefix[n],max = Integer.MIN_VALUE;
        int windowSize = n-k;
        for(int i=0;i<n-windowSize+1;i++){
            int val = total - (prefix[i+windowSize]-prefix[i]);
            max = Math.max(max, val);
        }
        return max;
    }
}
