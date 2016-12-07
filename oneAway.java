
public class oneAway {

	public static void main(String[] args) {
		System.out.println(oneAwayFunc("pale","ple"));
		System.out.println(oneAwayFunc("pales","pale"));
		System.out.println(oneAwayFunc("pale","bale"));
		System.out.println(oneAwayFunc("pale","bake"));
	}
	
	public static boolean oneAwayFunc(String s1, String s2){
		int lendif = Math.abs(s1.length() - s2.length());
		if (s1.length() == s2.length()){
			return (oneSwapAway(s1, s2));
		}
		if (lendif < 2){
			return (oneAddAway(s1, s2));
		}
		else {
			return false;
		}
	}

	public static boolean oneSwapAway(String s1, String s2){
		int count = 0;
		for (int i = 0; i < s1.length(); i++){
			if (s1.charAt(i) != s2.charAt(i)){
				count++;
				if (count > 1) return false;
			}	
		}
		return true;
	}
	
	public static boolean oneAddAway(String s1, String s2){
		String shortstr = (s1.length() < s2.length()) ? s1 : s2;
		String longstr = (s1.length() > s2.length()) ? s1 : s2;
		int i, j, count;
		i = j = 0;
		count = 0;
		while (i < shortstr.length() && j < longstr.length()){
			if (shortstr.charAt(i) != longstr.charAt(j)){
				count++;
				if (count > 1) return false;
				j++;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}
}
