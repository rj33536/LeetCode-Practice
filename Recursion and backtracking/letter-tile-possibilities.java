class Solution {
    public void get_perm(String tiles,String psf, List<String>perm){
        if(tiles.length()==0){
            perm.add(psf);
            return;
        }
        for(int i=0;i<tiles.length();i++){
            String rem = tiles.substring(0,i)+tiles.substring(i+1);
            String rv = tiles.substring(i,i+1);
            get_perm(rem,rv+psf,perm);
        }
    }
    public void add_subs(String tile, String psf, HashSet<String>ans){
        if(tile.length()==0){
            ans.add(psf);
            return ;
        }
        String rem = tile.substring(1);
        String rv = tile.substring(0,1);
        add_subs(rem,psf+rv,ans);
        add_subs(rem,psf,ans);
        
    }
    public int numTilePossibilities(String tiles) {
        HashSet<String>ans = new HashSet<String>();
        List<String>permutations = new ArrayList<String>();
        get_perm(tiles,"",permutations);
        
        for(String s:permutations){
            add_subs(s,"",ans);
        }
        
        return ans.size()-1;
        
    }
}
