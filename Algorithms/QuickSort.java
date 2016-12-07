public class QuickSort{
	public static void main(String[] args){
		int[] n = {14,17,13,15,19,10,3,16,9,12};
		int[] sorted = quicksort(n, 0, n.length - 1);
		for (int i: sorted){
			System.out.printf("%d, ", i);
		}
	}

	/* Recursively finds pivot values and sorts the arrays to the
	* left hand and right hand side of a given pivot.
	* return the original array sorted */
	public static int[] quicksort(int[] n, int start, int end){
		if (start < end){
			int pivot = partition(n,start,end);
			quicksort(n, start, pivot - 1);
			quicksort(n, pivot + 1, end);
		}
		return n;
	}

	/*Selects pivot value from the end of the given int[]
	* re orders n so that values less than pivot appear left
	* of the "wall" and those greater, are move right
	* swaps the pivot with the wall index at the end and returns
	* final pivot index to be used in recursive quicksort calls */
	public static int partition(int[] n, int start, int end){
		int pivot = n[end];
		int wall = start;
		for (int i = start; i < end; i++){
			if (n[i] < pivot){
				swap(n, i, wall);
				wall++;
			}
		}
		swap(n, wall, end);
		return wall;
	}

	//Swaps element a with element b in given int[] n
	public static void swap(int[] n, int a, int b){
		int temp = n[a];
		n[a] = n[b];
		n[b] = temp;
	}
}