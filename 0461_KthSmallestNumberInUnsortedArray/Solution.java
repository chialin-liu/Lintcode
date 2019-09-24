public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        return quickSort(k - 1, nums, 0, nums.length - 1);
    }
    private int quickSort(int k, int []nums, int start, int end){
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        if(start == end){
            return nums[start];
        }
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        if(start <= right && right >= k){
            return quickSort(k, nums, start, right);
        }
        else if(left <= end && left <= k){
            return quickSort(k, nums, left, end);
        }
        else return nums[k]; 
    }
}
