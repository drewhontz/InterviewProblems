
public class URLify {
	public static void main (String[] args){
		System.out.println(urlifyFunc("Shopping toes"));
		System.out.println(urlifyFunc("Where the Wild fern knows"));
		System.out.println(urlifyFunc("Whose's red fern is in my nose"));
		System.out.println(urlifyFunc("tictac"));	
	}
	
	public static String urlifyFunc(String s){
		char[] schar = s.toCharArray();
		int spacecount = 0, length = s.length(), addedbuffer, i;
		
		for (char c : schar){
			if (c == ' '){
				spacecount++;
			}
		}
		
		addedbuffer = 2 * spacecount + length;
		char[] returnstr = new char[addedbuffer];
		
		for (i = length - 1; i >= 0; i--){
			if (schar[i] != ' '){
				returnstr[addedbuffer - 1] = schar[i];
				addedbuffer--;
			} else {
				returnstr[addedbuffer - 1] = '0';
				returnstr[addedbuffer - 2] = '2';
				returnstr[addedbuffer - 3] = '%';
				addedbuffer -= 3;
			}
		}
		return new String(returnstr);
	}
}
