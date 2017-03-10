package leetCode;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int start = -1;
		int end = -1;
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		while (end < nums.length) {

			if (sum < s) {
				++end;
				if (end < nums.length)
					sum += nums[end];
			} else {
				int length = end - start;
				if (length < minLength) {

					minLength = length;

				}
				++start;
				if (start < nums.length)
					sum -= nums[start];

			}

		}

		return minLength;

	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum mss = new MinimumSizeSubarraySum();
		System.out.println(mss.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

}
