class Solution {
    public boolean capable(int[]nums, int cap, int D){
        int count = 0,i = 0, n = nums.length;
        //System.out.println("Start");
        while(i<n){
            int index = Arrays.binarySearch(nums,nums[i]+cap);
            count++;
            //System.out.println(index+" "+i);
            if(index>=0){
                if(index==n-1){
                    break;
                }
                i = index;
            }else{
                if(i==-index-2){
                    return false;
                }
                if(index<-n){
                    break;
                }
                
                i = -index-2;
                
            }
        }
        return (count<=D);
        
    }
    public int shipWithinDays(int[] weights, int D) {
        int[]prefix = new int[weights.length+1];
        for(int i=0;i<weights.length;i++){
            prefix[i+1] = weights[i] + prefix[i];
        }
        
        for(int i=1;i<=500000;i++){
            boolean flag = capable(prefix,i,D);
            //System.out.println(flag);
            if(flag){
                return i;
            }
        }
        return 0;
    }
}
