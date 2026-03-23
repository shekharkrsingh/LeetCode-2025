class Solution {
    public int lengthOfLongestSubstring(String s) {
         
         int ans=0;
         HashSet<Character>st=new HashSet<>();
         int j=0;

         for(int i=0;i<s.length();i++){
               char ch=s.charAt(i);
               if(st.contains(ch)){
                  st.remove(s.charAt(j));
                  j++;
               }
               st.add(ch);
               ans=Math.max(ans,st.size());
         }

         return ans;
    }
}