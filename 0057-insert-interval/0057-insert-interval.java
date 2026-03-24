class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        boolean flag=true;
        List<int[]> list=new ArrayList<>();
        List<int[]> merge=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(flag && intervals[i][0]>newInterval[0]){
                list.add(new int[]{newInterval[0], newInterval[1]});
                flag=false;
            }
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        if(flag){
            list.add(new int[]{newInterval[0], newInterval[1]});
        }

        int s=list.size();
        merge.add(list.get(0));

        for(int i=1;i<s;i++){
            int len=merge.size();
            if(merge.get(len-1)[1]>=list.get(i)[0]){
                merge.set(len-1, new int[]{merge.get(len-1)[0], (int)Math.max(list.get(i)[1], merge.get(len-1)[1])});
            }else{
                merge.add(list.get(i));
            }
        }

         n=merge.size();
        int[][] res=new int[n][2];

        for(int i=0;i<merge.size();i++){
            res[i]=merge.get(i);
        }

        return res;
    }
}