class Solution {
    public int lengthOfLongestSubstring(String s) {
         
         int ans=0;
         HashSet<Character>st=new HashSet<>();
         int j=0;

         for(int i=0;i<s.length();i++){
               char ch=s.charAt(i);
               if(st.contains(ch)){
                  while(true){
                      char ch1=s.charAt(j);
                      if(ch1==ch){
                          st.remove(ch1);
                          j++;
                          break;
                      }
                      st.remove(ch1);
                      j++;
                  }
               }
               st.add(ch);
               ans=Math.max(ans,st.size());
         }

         return ans;
    }
}