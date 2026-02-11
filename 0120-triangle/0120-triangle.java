class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        int[] curr= new int[n];
        int[] pre= new int[n+1];

        Arrays.fill(pre, 0);

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                pre[j]=Math.min(pre[j],pre[j+1])+triangle.get(i).get(j);
            }
        }

        return pre[0];
    }
}