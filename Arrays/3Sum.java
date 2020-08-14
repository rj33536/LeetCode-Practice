class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>>ans = new HashSet();
        for(int i=0;i<nums.length-2;i++){
            int target = -nums[i];
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer>temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                }else
                if(nums[j]+nums[k]>target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList(ans);
    }
}
