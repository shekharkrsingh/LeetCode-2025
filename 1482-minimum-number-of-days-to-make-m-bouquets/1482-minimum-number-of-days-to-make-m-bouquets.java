class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        int minDay = Integer.MAX_VALUE;
        int maxDay = 0;
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }
        return computerMinDayForMBouquets(minDay, maxDay, bloomDay, m, k);
    }

    private int computerMinDayForMBouquets(int minDay, int maxDay, int[] bloomDay, int m, int k) {
        int result = -1;
        while (minDay <= maxDay) {
            int mid = minDay + (maxDay - minDay) / 2;
            int noOfBounquets = dayRequired(mid, bloomDay, k);
            if (noOfBounquets >= m) {
                result = mid;
                maxDay = mid - 1;
            } else {
                minDay = mid + 1;
            }
        }

        return result;
    }

    private int dayRequired(int day, int[] bloomDay, int k) {
        int noOfBounquets = 0;
        int flowerCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowerCount++;
            } else {
                flowerCount = 0;
            }
            if (flowerCount == k) {
                noOfBounquets++;
                flowerCount = 0;
            }
        }

        return noOfBounquets;
    }
}