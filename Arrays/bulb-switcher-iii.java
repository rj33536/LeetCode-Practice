class Solution {
    public int numTimesAllBlue(int[] light) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE,count=0;
        for(int i=0;i<light.length;i++){
            min = Math.min(min, light[i]);
            max = Math.max(max, light[i]);
            if(min==1 && max==i+1){
                count++;
            }
            
        }
        return count;
    }
}
