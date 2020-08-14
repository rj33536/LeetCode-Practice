class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int target = 0,count=0;
        int n = A.length;
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        for(int i:C){
            for(int j:D){
                int item = i+j;
            if(map.containsKey(item)){
                int f = map.get(item)+1;
                map.put(item,f);
            }else{
                map.put(item,1);
            }
        }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp = target - A[i] - B[j];
                if(map.containsKey(temp)){
                        count+=map.get(temp);
                }
                
            }
        }
        return count;
    }
}
