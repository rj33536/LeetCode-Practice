class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
     int i=0,j=0,count=1;
        int[]f = new int[200];
        for(i=0;i<s.length();i++){
            int index = (int)s.charAt(i);
            
            f[index]++;
            while(f[index]==2){
                int prev = (int)s.charAt(j);
                f[prev]--;
                j++;
            }
            count = Math.max(count, i-j+1);
        }
        return count;
    }
}
