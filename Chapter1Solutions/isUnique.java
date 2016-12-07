
public class isUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUniqueFunc("dad"));
		System.out.println(isUniqueFunc("rad"));
		System.out.println(isUniqueFunc("abbacus"));
		
	}
	
	public static boolean isUniqueFunc (String s){
		boolean[] charState = new boolean[127];
		char[] sArray = s.toCharArray();
		for (char c : sArray){
			int ind = Character.getNumericValue(c);
			if (!charState[ind]) charState[ind] = true;
			else return false;
		}	
		return true;
	}

}
