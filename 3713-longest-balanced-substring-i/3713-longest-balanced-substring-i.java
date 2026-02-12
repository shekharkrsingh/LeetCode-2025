class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            int[] map= new int[26];
            Arrays.fill(map, 0);
            for(int j=i;j<n;j++){
                map[s.charAt(j)-'a']++;
                int check=map[s.charAt(i)-'a'];
                boolean flag=true;
                for(int k=0;k<26;k++){
                    if(map[k]!=0 && map[k]!=check){
                        flag=false;
                    }
                }
                if(flag)
                res=Math.max(res, j-i+1);
            }
        }

        return res;
    }
}