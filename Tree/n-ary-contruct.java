/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    static class Node{
        int data;
        ArrayList<Node>children;
        Node(int data){
            children = new ArrayList<Node>();
            this.data = data;
        }
    }
    static Node construct(int[]arr, int k){
        Node[]nodes = new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            nodes[i] = new Node(arr[i]);
        }
        int i=0,j=1;
        while(j<arr.length){
            
            for(int l=0;l<k && j<arr.length;l++){
                nodes[i].children.add(nodes[j]);
                j++;
            }
            i++;
        }
        return nodes[0];
    }
    static Node deserialize(int[]arr){
        
        Stack<Node>st = new Stack<Node>();
        Node root = new Node(arr[0]);
        st.push(root);
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]==-1){
                Node p = st.pop();
            }else{
                Node top = st.peek();
                Node node = new Node(arr[i]);
                top.children.add(node);
                st.push(node);
            }
        }
        return root;
        
    }
    static void postorder(Node root){
        if(root==null){
            return ;
        }
        for(int i=0;i<root.children.size();i++)
        postorder(root.children.get(i));
        System.out.print(root.data+" ");
        
    }
    
	public static void main (String[] args) {
		int[]arr= {1, 2, 3, -1,4, 5,-1,-1,-1, 6,-1, 7, 8,-1, 9,-1, 10,-1, 11,-1, -1, -1};
		
		//Node root = construct(arr,3);
		Node root = deserialize(arr);
		postorder(root);
		
	}
}
