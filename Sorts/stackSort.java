import java.util.Stack;


public class stackSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 1000; i++){
			int e = (int) (Math.random()*1000);
			s.push(e);
		}
		Stack<Integer> sorted = stackSortFunct(s);
		
		while(!sorted.isEmpty()){
			System.out.println(sorted.pop());
		}
}
	
	public static Stack<Integer> stackSortFunct (Stack<Integer> s){
		Stack <Integer> result = new Stack<Integer>();
		while (!s.isEmpty()){
			int temp = s.pop();
			while (!result.isEmpty() && result.peek() > temp){
				s.push(result.pop());
			}
			result.push(temp);
		}
		return result;
	}

}
