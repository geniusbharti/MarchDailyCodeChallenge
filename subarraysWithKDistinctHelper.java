class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctHelper(nums, k)
               - subarraysWithKDistinctHelper(nums, k-1);
    }

    public int subarraysWithKDistinctHelper(int[] nums, int k) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        int l = 0;
        int r = 0;
        int count = 0;

        while (r < nums.length) {
            numsCount.put(nums[r], numsCount.getOrDefault(nums[r], 0) + 1);

            while (numsCount.size() > k) {
                numsCount.put(nums[l], numsCount.get(nums[l]) - 1);
                if (numsCount.get(nums[l]) == 0) {
                    numsCount.remove(nums[l]);
                }
                l++;
            }

            //change - cal subarr
            count += (r - l + 1);
            r++;
        }

        return count;
    }
}
