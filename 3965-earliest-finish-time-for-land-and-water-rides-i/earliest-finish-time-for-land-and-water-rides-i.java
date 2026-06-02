class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
         int n = landStartTime.length;
        int m = waterStartTime.length;

        int minLandThenWater = Integer.MAX_VALUE;
        int minWaterThenLand = Integer.MAX_VALUE;

        // First Land then Water
        int minLandStart = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int land = landStartTime[i] + landDuration[i];
            minLandStart = Math.min(minLandStart, land);
        }

        for (int i = 0; i < m; i++) {
            int water = Math.max(waterStartTime[i], minLandStart)
                      + waterDuration[i];
            minLandThenWater = Math.min(minLandThenWater, water);
        }

        // First Water then Land
        int minWaterStart = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int water = waterStartTime[i] + waterDuration[i];
            minWaterStart = Math.min(minWaterStart, water);
        }

        for (int i = 0; i < n; i++) {
            int land = Math.max(landStartTime[i], minWaterStart)
                     + landDuration[i];
            minWaterThenLand = Math.min(minWaterThenLand, land);
        }

        return Math.min(minLandThenWater, minWaterThenLand);
    }
}