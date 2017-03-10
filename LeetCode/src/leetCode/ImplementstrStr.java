package leetCode;

public class ImplementstrStr {

	public int strStr(String haystack, String needle) {

		if (haystack.equals(needle))
			return 0;
		else if (haystack == null || haystack.length() == 0)
			return -1;
		else if (needle == null || needle.length() == 0)
			return 0;

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {

			if (haystack.charAt(i) == needle.charAt(j)) {

				if (j == needle.length() - 1) {
					return i - j;
				}
				j++;

			} else if (j > 0) {
				i = i - j;
				j = 0;
			}

			else {
				j = 0;
			}

		}

		return -1;

	}

	public static void main(String[] args) {
		ImplementstrStr iss = new ImplementstrStr();
		System.out.println(iss.strStr("mississippi", "pi"));
	}

}
