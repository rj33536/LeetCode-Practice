class Solution {
    static class Node{
        Boolean isEnd;
        Node[]children ;
        char c;
        Node(char c){
            this.isEnd = false;
            this.c = c;
            this.children = new Node[26];
            for(int i=0;i<26;i++){
                this.children[i] = null;
            }
        }
    }
    Node root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = this.root;
        while(word.length()!=0){
            char c = word.charAt(0);
            word = word.substring(1);
            int index = (int)c  -97;
            if(temp.children[index]==null){
                temp.children[index] = new Node(c);
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
        
    }
    public boolean check(String word, String pattern){
        int i=0,j=0;
        while(i<word.length() && j<pattern.length()){
            if(word.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                int index = (int)word.charAt(i);
                if(index<91){
                    return false;
                }
                i++;
            }
        }
        for(;i<word.length();i++){
            int index = (int)word.charAt(i);
            if(index<91){
                return false;
            }
        }
        return j==pattern.length();
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>ans = new ArrayList<Boolean>();
        this.root = new Node('a');
        for(int i=0;i<queries.length;i++){
            //insert(queries.get(i));
            ans.add(check(queries[i],pattern));
            
        }
        return ans;
    }
}
