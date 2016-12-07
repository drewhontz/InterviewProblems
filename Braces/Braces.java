public class Braces{
	public static void main (String[] args){
		String[] expressions = {")(){}","[]({})","([])","{()[]}","([)]",
				"{[()}}","{[()]}","(){}{}{}[]()","([]{()}[(])]"};
		
		for (String ex : expressions){
			System.out.println(areBracesMatched(ex));
		}
	}

	public static int areBracesMatched(String str){

		/* All closes are in either the next or last position in valid inputs
		* therefore, if open brace is found, check next or last index in string
		* for the match, if it cannot be found, return 0.
		* if it can be found, remove both elements from the string
		* if the string is ever empty, return 1. */
		if (str.length() == 0) return 0;
		StringBuilder s = new StringBuilder(str);

		while (s.length() >= 0){
			char first = s.charAt(0);
			char next = s.charAt(1);
			int last = s.length() - 1;

			/* If string starts with a close bracket, return 0 immediately */
			if (first == ')' | first == ']' | first == '}' ){
				return 0;
			}

			/* find close bracket based off first char and checks to see if next
			* or last char in current stringbuilder is a match
			* if a match is found, both matching characters are removed*/
			else {
				char close;
				switch (first) {
					case '(': close = ')';
						break;
					case '{' : close = '}';
						break;
					case '[' : close = ']';
						break;
					default: close = '0';
						break;
				}

				/* Break statement was added in the event there was a match at both
				* next and last */
				if (next == close){
					s = s.deleteCharAt(1);
					s = s.deleteCharAt(0);
					break;
				}

				if (s.charAt(last) == close){
					s = s.deleteCharAt(last);
					s = s.deleteCharAt(0);
				}

				else {
					return 0;
				}
			}
		}
		return 1;
	}
}