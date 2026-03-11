class Solution {
    public int[] recoverArray(int[] nums) {
         Arrays.sort(nums);
        int n = nums.length / 2;

        for(int i = 1; i < nums.length; i++) {

            int diff = nums[i] - nums[0];

            if(diff <= 0 || diff % 2 != 0) continue;

            int k = diff / 2;

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int[] arr = new int[n];
            int idx = 0;

            boolean possible = true;

            for(int num : nums) {

                if(map.get(num) == 0) continue;

                int higher = num + 2 * k;

                if(!map.containsKey(higher) || map.get(higher) == 0) {
                    possible = false;
                    break;
                }

                arr[idx++] = num + k;

                map.put(num, map.get(num) - 1);
                map.put(higher, map.get(higher) - 1);
            }

            if(possible) return arr;
        }

        return new int[]{};
    }
}