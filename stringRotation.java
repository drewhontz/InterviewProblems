
public class stringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringRotationFunc("waterbottle","erbottlewat"));
		System.out.println(stringRotationFunc("double-helix","uble-helixdo"));
		System.out.println(stringRotationFunc("experimental","mentalerxperi"));
	}

	public static boolean stringRotationFunc(String s1, String s2){
		StringBuilder r = new StringBuilder(s2.length() *2);
		r.append(s2).append(s2);
		return (isSubString(r.toString(), s1));
	}
	
	public static boolean isSubString(String s1, String s2){
		return (s1.contains(s2));
	}
}
