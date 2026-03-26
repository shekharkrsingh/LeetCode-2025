class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        Queue<Integer> q= new LinkedList<>();
        q.offer(-1);
        int cnt=0;
        int max=0;
        for(int i=0;i<n;i++){
            System.out.println(q.size());
            if(nums[i]==0 && cnt<k){
                cnt++;
                q.offer(i);
            }else if(nums[i]==0 && cnt==k){
                int idx=q.peek();
                max=Math.max(i-idx-1, max);
                q.poll();
                q.offer(i);
            }
            max=Math.max(i-q.peek(), max);
        }

        return max;
    }
}