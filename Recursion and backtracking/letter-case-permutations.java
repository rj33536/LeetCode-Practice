class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String>ans = new ArrayList<String>();
        if(S.length()==0){
            ans.add("");
            return ans;
        }
        char c = S.charAt(0);
        if(Character.isDigit(c)){
            String rv = S.substring(0,1);
            List<String>temp = letterCasePermutation(S.substring(1));
            for(String str:temp){
                ans.add(rv+str);
            }
        }else{
            String rv = S.substring(0,1);
            List<String>temp = letterCasePermutation(S.substring(1));
            for(String str:temp){
                ans.add(rv.toLowerCase()+str);
            }
            for(String str:temp){
                ans.add(rv.toUpperCase()+str);
            }
            
//             if(Character.isUpperCase(c)){
                
//             }else{
                
//             }
        }
        return ans;
    }
}
