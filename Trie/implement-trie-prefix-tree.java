class Trie {

    /** Initialize your data structure here. */
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
    public Trie() {
        this.root = new Node('a');
    }
    
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        while(word.length()!=0){
            char c = word.charAt(0);
            word = word.substring(1);
            int index = (int)c  -97;
            if(temp.children[index]==null){
                return false;
            }
            temp = temp.children[index];
        }
        if(temp==null) return false;
        
        return temp.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        String word = prefix;
        Node temp = root;
        while(word.length()!=0){
            char c = word.charAt(0);
            word = word.substring(1);
            int index = (int)c  -97;
            if(temp.children[index]==null){
                return false;
            }
            temp = temp.children[index];
        }
        if(temp==null) return false;
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
