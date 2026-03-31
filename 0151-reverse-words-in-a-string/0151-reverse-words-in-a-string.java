class Solution {
    public String reverseWords(String s) {
        String[] list= s.split(" ");
        StringBuilder sb= new StringBuilder();
        for(int i=list.length-1; i>=0;i--){
            if(list[i].length()!=0){
                sb.append(list[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}