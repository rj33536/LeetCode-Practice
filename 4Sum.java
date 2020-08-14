class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>>ans = new HashSet();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = target - nums[i] - nums[j];
                int start = j+1,end = n-1;
                while(start<end){
                    int val = nums[start]+nums[end];
                    if(val==temp){
                        List<Integer>rv = new ArrayList<Integer>();
                        rv.add(nums[i]);
                        rv.add(nums[j]);
                        rv.add(nums[start]);
                        rv.add(nums[end]);
                        ans.add(rv);
                        start++;
                        end--;
                    }else if(val<temp){
                        start++;
                    }else{
                        end--;
                    }
                    
                }
                
            }
        }
        return new ArrayList(ans);
    }
}
