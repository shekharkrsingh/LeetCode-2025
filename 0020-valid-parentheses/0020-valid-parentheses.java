class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            if(ch==')'){
                if(st.isEmpty() || st.peek()!='('){
                    return false;
                }else{
                    st.pop();
                }
            }
            if(ch=='}'){
                if(st.isEmpty() || st.peek()!='{'){
                    return false;
                }else{
                    st.pop();
                }
            }
            if(ch==']'){
                if(st.isEmpty() || st.peek()!='['){
                    return false;
                }else{
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }
}