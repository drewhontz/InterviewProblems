import java.util.Arrays;

public class Anagrams{
	public static void main(String[] args){
		String[] firstWords = {"cinema", "host", "aba", "train"};
		String[] secondWords = {"iceman", "shot", "bab", "rain"};
		checkAnagrams(firstWords, secondWords);
	}

	public static int checkAnagrams(String firstWord, String secondWord){
		//quick checks to see if we can immediately return success or failure
		if (firstWord.length() != secondWord.length()) return 0;
		else if (firstWord.equals(secondWord)) return 1;

		//creates char array of string, sorts the new char[]
		char[] firstCharArray, secondCharArray;
		firstCharArray = firstWord.toCharArray();
		secondCharArray = secondWord.toCharArray();
		Arrays.sort(firstCharArray);
		Arrays.sort(secondCharArray);

		//compares ith character in each sorted char[], returns 0 if they do not match
		for (int i = 0; i < firstCharArray.length; i++){
			if (firstCharArray[i] != secondCharArray[i]) return 0;
		}

		//if all characters have been matched, return success
		return 1;
	}

	public static void checkAnagrams(String[] firstWords, String[] secondWords){
		if (firstWords.length != secondWords.length) throw new UnsupportedOperationException();
		for (int i = 0; i < firstWords.length; i++){
			System.out.println(checkAnagrams(firstWords[i], secondWords[i]));
		}
	}
}