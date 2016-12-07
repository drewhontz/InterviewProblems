
public class palindromePermutation {

	public static void main(String[] args) {
		System.out.println(palindromePermutationFunc("ttaaccd"));
		System.out.println(palindromePermutationFunc("ttaacefcdd"));
		System.out.println(palindromePermutationFunc("tacocat"));
		System.out.println(palindromePermutationFunc("araara"));
		System.out.println(palindromePermutationFunc("hadedah"));
	}
	
	public static boolean palindromePermutationFunc(String s){
		char[] c = s.toCharArray();
		boolean[] cbar = new boolean[127];
		int count = 0;
		
		for (char x : c){
			int ci = Character.getNumericValue(x);
			cbar[ci] = toggle(cbar[ci]);
		}
		
		for (boolean t : cbar){
			if (t) count++;
		}
		
		if (s.length() % 2 == 0) return !(count > 0);
		else return !(count > 1);
	}
	
	public static boolean toggle(boolean b){
		return ((b) ? false : true);
	}
}
