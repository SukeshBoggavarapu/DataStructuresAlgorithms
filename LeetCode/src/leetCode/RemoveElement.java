package leetCode;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0)
			return 0;
	
		int j = nums.length - 1;
		int i = 0;

		while (i <= j) {

			if (nums[i] == val) {

				while (nums[j] == val && i < j)
					j--;
				if (i != j) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}else
					return i;
			}
			i++;

		}

		return i;

	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		System.out.println(re.removeElement(new int[] {3,2,2,3}, 3));
	}

}
