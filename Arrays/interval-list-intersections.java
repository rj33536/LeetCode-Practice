class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;
        ArrayList<int[]>ans = new ArrayList<int[]>();
        while(i<A.length && j<B.length){
            if(A[i][1]>=B[j][1] && A[i][0]<=B[j][1]){
                int[]temp = new int[2];
                temp[0] = Math.max(B[j][0],A[i][0]);
                temp[1] = B[j][1];
                ans.add(temp);
                j++;
                
            }else if(A[i][1]<=B[j][1] && A[i][1]>=B[j][0]){
                int[]temp = new int[2];
                temp[0] = Math.max(B[j][0],A[i][0]);
                temp[1] = A[i][1];
                ans.add(temp);
                i++;
            }
            else{
                if(A[i][0]>B[j][1]){
                    j++;
                }else if(A[i][1]<B[j][0]){
                    i++;
                }else{
                    i++;
                j++;
                }
                
                
            }
            
            
        }
        int [][]overlap = new int[ans.size()][2];
        for(i=0;i<ans.size();i++){
            overlap[i] = ans.get(i);
        }
        
        return overlap;
    }
}
