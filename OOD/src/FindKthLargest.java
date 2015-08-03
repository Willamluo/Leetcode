import java.util.ArrayList;

public class FindKthLargest {

	public int findKthLargest(int[] nums, int k) {
		if(k > nums.length)
			return -1;
		if(nums.length == 1)
			return nums[0];
		return findKthLargest(nums, 0, nums.length - 1, k);
	}
	
	/**
	 * quick sort select
	 * @param nums
	 * @param low
	 * @param high
	 * @param k
	 * @return
	 */
	private int selection(int[] nums, int low, int high, int k)
	{
		if(low > high)
			return -1;
		if(low == high)
			return nums[low];
		int pivot = partition(nums, low, high, low);
		int L1 = high - pivot;
		int L2 = pivot - low;
		if(k == L1 + 1)
			return nums[pivot];
		else if(k < L1 + 1)
			return selection(nums, pivot + 1, high, k);
		else
			return selection(nums, low, pivot - 1, k - L1 - 1);
		
	}
	
	private int findKthLargest(int[] nums, int low, int high, int k)
	{
		if(low > high)
			return -1;
		if(low == high)
			return nums[low];
		int[] medians = divideIntoGroup(nums, low, high);
		int pivot = findMedianInMedians(medians, nums);
		pivot = partition(nums, low, high, pivot);
		int L1 = high - pivot;
		int L2 = pivot - low;
		if(L1 == k - 1)
			return nums[pivot];
		else if(L1 + 1 >= k)
			return findKthLargest(nums, pivot + 1, high, k);
		else
			return findKthLargest(nums, low, pivot - 1, k - L1 - 1);
		
	}
	public int partition(int[] nums, int low, int high, int pivot) {
		int p = nums[pivot];
		int i = low;
		int j = high + 1;
		swap(nums, low, pivot);
		pivot = low;
		while (true) {
			while (nums[++i] <= p)
				if(i == high)
					break;
			while (nums[--j] > p)
				if(i == low)
					break;
			if(i >= j)
				break;

				swap(nums, i, j);
			
		}
		swap(nums, low, j);
		return j;
	}

	private void swap(int[] nums, int low, int pivot) {
		// TODO Auto-generated method stub
		int temp = nums[low];
		nums[low] = nums[pivot];
		nums[pivot] = temp;
	}

	private int[] divideIntoGroup(int[] nums, int low, int high) {
		// ArrayList<Integer> medians = new ArrayList<Integer>();
		int numberOfGroups = (int) Math.ceil(((double) (high - low + 1)) / 5.0d);
		int[] medians = new int[numberOfGroups];
		int groups = 0;
		for (int i = low; i <= high; i = i + 5) {
			int h = (i + 4) > high ? high : i + 4;
			int median = findMedian(nums, i, h);
			medians[groups++] = median;
		}
		return medians;
	}

	public int findMedian(int[] nums, int start, int end) {
		int median = Integer.MAX_VALUE;
		int mid = start + (end - start) / 2;
		int index = -1;
		for (int i = start; i <= mid; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = start; j <= end; j++) {
				if (nums[j] > max && nums[j] < median)
				{
					max = nums[j];
					index = j;
				}
				
			}
			median = max;		
		}
		return index;
	}
	
	public int findMedianInMedians(int[] medians, int[] nums)
	{
		int median = Integer.MAX_VALUE;
		int index = -1;
		int mid = (medians.length - 1) / 2;
		for (int i = 0; i <= mid; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < medians.length; j++) {
				if (nums[medians[j]] > max && nums[medians[j]] < median)
				{
					max = nums[medians[j]];
					index = medians[j];
				}
				
			}
			median = max;		
		}
		return index;
	}
}
