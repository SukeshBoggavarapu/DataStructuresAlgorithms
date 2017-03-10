package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {

		if (t.length() > s.length())
			return "";

		int countnegs = t.length();
		int minlength = Integer.MAX_VALUE;
		int start = -1;
		int end = 0;
		int minstart = -1;
		int minend = -1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			map.put(c, map.get(c) == null ? -1 : map.get(c) - 1);

		}

		for (int m = 0; m < s.length(); m++) {
			char k = s.charAt(m);
			if (map.containsKey(k)) {
				if (map.get(k) < 0)
					countnegs--;
				map.put(k, map.get(k) + 1);
				if (countnegs == 0) {
					end = m;
					for (int j = start + 1; j < s.length(); j++) {
						char b = s.charAt(j);
						if (map.containsKey(b)) {

							map.put(b, map.get(b) - 1);
							if (map.get(b) < 0) {
								start = j;
								countnegs++;
								break;
							}

						}

					}
					if (end - start < minlength) {
						minstart = start;
						minend = end;
						minlength = end - start;
					}

				}
			}

		}

		return (minstart != -1 ? s.substring(minstart, minend + 1) : "");

	}

	public static void main(String[] args) {

		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("cabwefgewcwaefgcf", "cae"));
	}
}