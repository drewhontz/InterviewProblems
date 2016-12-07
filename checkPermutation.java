public class checkPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPermutationFunc("racecar", "racecar"));
		System.out.println(checkPermutationFunc("racecar", "aaccerr"));
		System.out.println(checkPermutationFunc("dad", "dda"));
		System.out.println(checkPermutationFunc("radical", "aaccerr"));
		System.out.println(checkPermutationFunc("racecar", "aaerr"));
	}
	
	public static boolean checkPermutationFunc(String s1, String s2){
		if (s1.length() != s2.length()) return false;
		if (s1.equals(s2)) return true;
		else {
			s1 = sort(s1);
			s2 = sort(s2);
			return (s1.equals(s2));
		}
	}
	
	public static String sort(String s){
		char[] sChar = s.toCharArray();
		java.util.Arrays.sort(sChar);
		return new String(sChar);
	}

}
