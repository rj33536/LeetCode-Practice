class Solution {
    static class pair{
        String str;
        String f;
        pair(String str, String f){
            this.str = str;
            this.f = f;
        }
    }
    public String decodeString(String s) {
        Stack<pair>st = new Stack<pair>();
        st.push(new pair("","1"));

        boolean flag = false;
        for(int i=0;i<s.length();i++){
            String c = s.substring(i,i+1);
            if(Character.isDigit(s.charAt(i))){
                if(flag==false){
                    st.push(new pair("","0"));
                    flag = true;
                }
                pair top = st.peek();
                top.f+=c;
            }else if(s.charAt(i)=='['){
                flag = false;
                continue;
            }else if(s.charAt(i)==']'){
                flag = false;
                pair top = st.pop();
                String rv = top.str;
                int f = Integer.valueOf(top.f);
                String temp = "";
                for(int j=0;j<f;j++){
                    temp+=rv;
                }
                pair second = st.peek();
                second.str+=temp;
                
            }else{
                flag = false;
                pair top = st.peek();
                top.str+=c;
            }
        }
        
        pair top = st.pop();
        String rv = top.str;
        int f = Integer.valueOf(top.f);
        String temp = "";
        for(int j=0;j<f;j++){
            temp+=rv;
        }
        return temp;
        
    }
}
