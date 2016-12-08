/* Clarify - No invalid inputs? Only strings with characters a-z A-Z?
   Assuming that a != A? If there is not a repeat, do we concat 1 or just the letter?

   Test Cases - empty string
              - a string that actually gets replaced
              - a string that has aA to test previous case
              - a string that is not shorter when compressed

    Brainstorm - Use a runner method to compare the char to its previous char in
    the string, if they match, update the count. If they don't, append the
    character to a return string alongside the current count. Compare the answer
    to the input string and return the shorter option

    Runtime Analysis - O(N) time (string builder append is O(1)) and O(N) space worst case

 */

import java.lang.StringBuilder;

public class stringCompression2 {

public static void main(String[] args) {
        System.out.println("Expecting '' : " + stringCompress("")); // expecting ''
        System.out.println("Expecting 'a1' : " + stringCompress("a")); // expecting ''
        System.out.println("Expecting 'a3b2C5d1' : " + stringCompress("aaabbCCCCCd")); // expecting a3b2C5d1
        System.out.println("Expecting 'a3b2C6' : " + stringCompress("aaabbCCCCCC")); // expecting a3b2C6
        System.out.println("Expecting 'aabb' : " + stringCompress("aabb")); // expecting aabb
}

public static String stringCompress(String s) {
        if (s.equals("")) return "Please provide a non empty string";
        if (s.length() == 1) return s + 1;
        StringBuilder answer = new StringBuilder();
        int count = 1;
        int i;
        for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                        count++;
                } else {
                        answer.append(s.charAt(i-1));
                        answer.append(count);
                        count = 1;
                }

        }
        answer.append(s.charAt(i - 1)).append(count);
        return (s.length() > answer.length()) ? answer.toString() : s;
}
}
