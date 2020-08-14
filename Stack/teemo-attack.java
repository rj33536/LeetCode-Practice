class Solution {
    public boolean overlap(int[]first,int[]second){
        if(first[1]>=second[0]){
            return true;
        }
        return false;
    }
    public void merge(int[]first,int[]second){
        first[1] = Math.max(first[1],second[1]);
    }
    static class myComparator implements Comparator<int[]>{
        public int compare(int[]first,int[]second){
            if(first[0]<second[0]){
                return -1;
            }
            if(first[0]>second[0]){
                return 1;
            }
            
            return 0;
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new myComparator());
        int i=0,j=1;
        boolean flag = false;
        if(intervals.length<=1) return intervals;
        Stack<int[]>st = new Stack();
        st.push(intervals[0]);
        for(j=1;j<intervals.length;j++){
            int[]top = st.pop();
            if(overlap(top,intervals[j])){
                merge(top,intervals[j]);
                st.push(top);
            }else{
                st.push(intervals[j]);
                intervals[i++] = top;
                
            }
        }
        int[]top = st.pop();
        intervals[i++] = top;
        
        return Arrays.copyOfRange(intervals,0,i);
    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int[][]intervals = new int[timeSeries.length][2];
        
        for(int i=0;i<timeSeries.length;i++){
            intervals[i][0] = timeSeries[i];
            intervals[i][1] = timeSeries[i]+duration;
        }
        intervals = merge(intervals);
        int count=0;
        for(int i=0;i<intervals.length;i++){
            count+=intervals[i][1] - intervals[i][0];
        }
        
        return count;
    }
}
