class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];

        for(int i=1; i<n; i++){
            prefix[i] = nums[i] * prefix[i-1];
        }

        for(int i=n-2; i>=0; i--){
            suffix[i] = nums[i] * suffix[i+1];
        }

        for(int i=1; i<n-1; i++){
            ans[i] = prefix[i-1] * suffix[i+1];
        }

        ans[0] = 1*suffix[1];
        ans[n-1] = 1*prefix[n-2];
        
        return ans;
    }
}
