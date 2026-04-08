class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {

        int mod = 1_000_000_007;
        for(int[] a : queries){
            for(int i = a[0];i<=a[1];i += a[2]){
                long p = (long)(nums[i])*a[3];
                nums[i] =(int) (p%mod);
            }
        }
        int s = 0;
        for(int i : nums) s ^= i;
        return s;
    }
}