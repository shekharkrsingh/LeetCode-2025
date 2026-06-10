class Solution {
    public int totalFruit(int[] fruits) {
        int numberofFruits = fruits.length;
        Map<Integer, Integer> fruitsFreq = new HashMap<>();
        int fruitCnt = 0;
        int start = 0;
        int maxFruitInBasket = 0;
        for (int i = 0; i < numberofFruits; i++) {
            if (!fruitsFreq.containsKey(fruits[i]) || fruitsFreq.get(fruits[i])==0) {
                fruitsFreq.put(fruits[i], 1);
                fruitCnt++;
            } else {
                fruitsFreq.put(fruits[i], fruitsFreq.get(fruits[i]) + 1);
            }
            if (fruitCnt > 2) {
                fruitsFreq.put(fruits[start], fruitsFreq.get(fruits[start]) - 1);
                if (fruitsFreq.get(fruits[start]) == 0) {
                    fruitCnt--;
                }
                start++;
            }
            maxFruitInBasket = Math.max(maxFruitInBasket, i - start + 1);
        }

        return maxFruitInBasket;
    }
}