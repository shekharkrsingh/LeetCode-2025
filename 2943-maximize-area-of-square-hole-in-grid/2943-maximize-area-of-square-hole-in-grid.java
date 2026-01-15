class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        int hl=hBars.length;
        int vl=vBars.length;

        int maxH=0;
        int maxV=0;
        
        int count=0;
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        for(int i=1;i<hl;i++){
            if(hBars[i]-hBars[i-1]==1){
                count++;
                maxH=Math.max(maxH, count);
            }else{
                count=0;
            }
        }

        count=0;

        for(int i=1;i<vl;i++){
            if(vBars[i]-vBars[i-1]==1){
                count++;
                maxV=Math.max(count, maxV);
            }else{
                count=0;
            }
        }

        maxH=hl==1?2:maxH+2;
        maxV=vl==1?2:maxV+2;

        int resultMin=Math.min(maxH, maxV);
        
        return resultMin*resultMin;
    }
}