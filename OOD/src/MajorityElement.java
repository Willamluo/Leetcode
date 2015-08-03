
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    private int majorityElement(int[] nums, int low, int high)
    {
        if(low > high)
            return -1;
        if(low == high)
            return nums[low];
        int mid = low + (high - low) / 2;
        int lm = majorityElement(nums, low, mid);
        int rm = majorityElement(nums, mid + 1, high);
        if(lm != -1 && countElement(nums, lm, low, high) > (high - low + 1) / 2)
            return lm;
        if(rm != -1 && countElement(nums, rm, low, high) > (high - low + 1) / 2)
            return rm;
        return -1;
    }
    
    private int countElement(int[] nums, int e, int low, int high)
    {
        int count = 0;
        for(int i = low; i <= high; i++)
        {
            if(nums[i] == e)
                count++;
        }
        return count;
    }
}
