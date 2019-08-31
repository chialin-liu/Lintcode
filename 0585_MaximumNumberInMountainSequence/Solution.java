public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] >= nums[mid+1]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(start + 1 <= nums.length - 1){
            if(nums[start] >= nums[start+1]){
                return nums[start];
            }
            else{
                return nums[end];
            }
        }
        
        return nums[start];
    }
}
