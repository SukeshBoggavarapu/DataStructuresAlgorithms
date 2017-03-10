package strings;

public class ReverseWords {

	public static void reverseString(String string) {

		char[] cArray = string.toCharArray();
		int i = 0;
		for (int j = 0; j < cArray.length; j++) {

			if (cArray[j] == ' ') {
				reverse(cArray, i, j - 1);
				i = j + 1;
			}
		}
		reverse(cArray, i, cArray.length - 1);
		reverse(cArray, 0, cArray.length - 1);
		String s = cleanspaces(cArray, cArray.length);

		for (int m = 0; m < cArray.length; m++) {
			System.out.print(cArray[m]);
		}

	}

	public static char[] reverse(char[] s, int startIndex, int endIndex) {

		char temp;
		while (startIndex < endIndex) {
			temp = s[startIndex];
			s[startIndex] = s[endIndex];
			s[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		return s;

	}

	public static String cleanspaces(char[] s,int length){
		
		int i=0,j=0;
		while(j<length){
			
			while(j<length && s[j]==' ')j++;
			while(j<length && s[j]!=' ')s[i++]=s[j++];
			s[i++]=' ';
			
		}
		
		return new String(s, 0, i);
		
	}

	public static void main(String[] args) {

		reverseString(" ");

	}

}