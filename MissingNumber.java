/* Clarify
   Inputs = Array of integers, what happens when you are given a sequence like 1,2,3? Should we return 0 or 4?
   Test Cases = [1,2,3], [], [-1,-2,-3], [4,8,6,5], [1,3,5]
   Brainstorm
   Runtime - O(N) Runtime
   */
import java.util.Arrays;

public class MissingNumber{

  public static void main(String[] args){
    int[] a = {4,8,6,5};
    System.out.println("expecting 7: " + findMissingNumber(a));

    int[] b = {-1,-2,-3};
    System.out.println("expecting exception: " + findMissingNumber(b));

    int[] c = {1,2,3};
    System.out.println("expecting exception: " + findMissingNumber(c));

    int[] e = {1,3,5};
    System.out.println("expecting mult: " + findMissingNumber(e));

    int[] d = {};
    System.out.println("expecting exception: " + findMissingNumber(d));
  }

  public static int findMissingNumber(int[] input){
    int len = input.length;
    // Check if input is empty
    if (len == 0){
      throw new IllegalArgumentException("Sequence is empty");
    }

    // Compute sum of integers in input
    int sum = 0;
    Arrays.sort(input);
    for (int i : input) {
      sum += i;
    }

    // Check to see if sequence provided is not missing a value
    int sumOfSet = input[0] + input[len-1];
    if ((sumOfSet*len)/2 == sum){
      System.out.println("Argument array is not missing a value");
    }

    int total = (sumOfSet * (len+1))/2;
    int answer = total - sum;
    System.out.println(Arrays.asList(input).indexOf(answer));
    return answer;
  }
}
