class Solution {
    public int lengthOfLongestSubstring(String s) {
         
         int ans=0;
         HashMap<Character,Integer>mp=new HashMap<>();
         int j=0;

         for(int i=0;i<s.length();i++){
               char ch=s.charAt(i);
               if(mp.containsKey(ch)){
                  while(true){
                      char ch1=s.charAt(j);
                      if(ch1==ch){
                          mp.remove(ch1);
                          j++;
                          break;
                      }
                      mp.remove(ch1);
                      j++;
                  }
               }
               mp.put(ch,1);
               ans=Math.max(ans,mp.size());
         }

         return ans;
    }
}