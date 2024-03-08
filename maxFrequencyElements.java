class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] frq = new int[101];
        int maxFq = 0;
        for(int i=0; i<nums.length; i++){
            frq[nums[i]]++;
            if(frq[nums[i]] > maxFq) maxFq = frq[nums[i]];
        }
        int ans = 0;
        for(int i=0; i<101; i++){
            if(frq[i] == maxFq) ans+=frq[i];
        }
        return ans;
    }
}
