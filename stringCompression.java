
public class stringCompression {

	public static void main(String[] args) {
		System.out.println(stringCompressionFunc("aaabbccdddeeaa"));
		System.out.println(stringCompressionFunc("aaaarrdvaark"));
		System.out.println(stringCompressionFunc("cccaabb22ee"));		 
	}
	
	public static String stringCompressionFunc(String s){
		StringBuilder str = new StringBuilder();
		char prev = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++){
			char cur = s.charAt(i);
			if (prev == cur){
				count++;
			}	
			else {
				str.append(prev).append(count);
				count = 1;
			}
			prev = cur;
		}
		str.append(prev).append(count);
		return (str.length() < s.length()) ? str.toString() : s;
	}
}
