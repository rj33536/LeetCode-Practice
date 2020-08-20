class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int ans = Integer.MIN_VALUE;
        int[]prefix = new int[A.length+1];
        for(int i=0;i<A.length;i++){
            prefix[i+1] = prefix[i]+A[i];
        }
        for(int i=0;i<prefix.length-L-M;i++){
            for(int j=i+L;j<prefix.length-M;j++){
                int temp = prefix[i+L]-prefix[i]+prefix[j+M]-prefix[j];
                //System.out.println(temp);
                ans = Math.max(ans,temp);
            }
            
        }
        for(int i=0;i<prefix.length-L-M;i++){
            for(int j=i+M;j<prefix.length-L;j++){
                int temp =prefix[i+M]-prefix[i]+prefix[j+L]-prefix[j];
                ans = Math.max(ans,temp);
            }
            
        }
        return ans;
        
        
    }
}
