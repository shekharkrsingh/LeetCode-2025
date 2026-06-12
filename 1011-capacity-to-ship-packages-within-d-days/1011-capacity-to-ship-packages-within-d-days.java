class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int length=weights.length;
        int minWeight=0;
        int maxWeight=0;
        for(int weight: weights){
            minWeight=Math.max(minWeight, weight);
            maxWeight+=weight;
        }
        return computeWeight(minWeight, maxWeight, weights, days);
    }

    private int computeWeight(int minWeight, int maxWeight, int[] weights, int days){
        int totalWeight=minWeight;
        while(minWeight<=maxWeight){
            int mid=minWeight+(maxWeight-minWeight)/2;
            int daysRequired=noOfDays(mid, weights);
            if(daysRequired<=days){
                totalWeight=mid;
                maxWeight=mid-1;
            }else{
                minWeight=mid+1;
            }
        }
        return totalWeight;
    }

    private int noOfDays(int weight, int[] weights){
        int day=0;
        int sumWeight=0;
        for(int i=0;i<weights.length;i++){
            if(sumWeight+weights[i]>weight){
                day++;
                sumWeight=0;
            }
            sumWeight+=weights[i];
        }
        if(sumWeight>0){
            day++;
        }
        return day;
    }
}