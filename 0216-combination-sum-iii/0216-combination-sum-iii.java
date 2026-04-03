class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        sol(9, n, k, list, result);
        return result;

    }

    private void sol(int idx,int n, int k, List<Integer> list, List<List<Integer>> result){
        if(idx==0){
            if(n==0 && list.size()==k){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        sol(idx-1, n, k,  list, result);
        list.add(idx);
        sol(idx-1, n-idx, k, list, result);
        list.remove(list.size()-1);
        
    }
}