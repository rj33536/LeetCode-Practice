class Solution {
    public int binarySearch(int[]nums,int val, int start){
        int end = nums.length-1,mid=start;
        while(end>=start){
            mid = (start+end)/2;
            if(nums[mid]==val){
                start = mid+1;
            }else if(nums[mid]>val){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        if(nums[mid]>=val)
        return mid;
        return mid-1;
    }
    public int maxWidthRamp(int[] A) {
        int n = A.length,max = n-1;
        int[]suf = new int[n];
        int[]vals = new int[n];
        for(int i=n-1;i>=0;i--){
            if(A[max]<A[i]){
                max = i;
            }
            suf[i] = max;
            vals[i] = A[max];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int index = binarySearch(vals,A[i],i);
            ans = Math.max(ans,index-i); 
        }
        
        return ans;
    }
}
