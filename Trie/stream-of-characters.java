class StreamChecker {
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
    String qs;
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
    public StreamChecker(String[] words) {
        this.root = new Node('a');
        for(String word:words){
            StringBuilder sb=new StringBuilder(word);  
            sb.reverse();  
            insert(sb.toString());
        }
        qs = "";
    }
    public boolean startsWith(String prefix) {
        String word = prefix;
        Node temp = root;
        int i=0;
        while(word.length()!=i){
            char c = word.charAt(i);
            //System.out.println(c+" "+temp.isEnd);
            i++;
            int index = (int)c  -97;
            if(temp.children[index]==null){
                return false;
            }
            temp = temp.children[index];
            if(temp.isEnd){
                return true;
            }
        }
        if(temp==null) return false;
        
        return temp.isEnd;
    }
    public boolean query(char letter) {
        qs = Character.toString(letter) + qs;
        return startsWith(qs);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
