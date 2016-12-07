
public class rotateMatrix {

	public static void main(String[] args) {
		int[][] test = {{0,1,2,3,4},{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
		printMatrix(test);
		System.out.println("\n\n");
		printMatrix(rotateMatrixFunc(test));
		
	}

	public static int[][] rotateMatrixFunc(int[][] m){
		int n = m[0].length - 1;
		for (int layer = 0; layer < (n+1)/2; layer++){
			int start = layer;
			int end = n - layer;
			for (int i = start; i < end; i++){
				int offset = i - start;
				int top = m[i][start];
				
				//moves left column into top row
				m[i][start] = m[start][end - offset];
				//move bottom row into left column
				m[start][end - offset] = m[end - offset][end];
				//move right column into bottom row
				m[end - offset][end] = m[end][i];
				//moves top row into right column
				m[end][i]= top;
				
			}
		}
			return m;
	}
	
	public static void printMatrix(int[][] m){
		int limit = m[0].length;
		for (int i = 0; i < limit; i++){
			for (int j = 0; j < limit; j++){
				System.out.printf("|%d|",m[j][i]);
			}
			System.out.println('\n');
		}
	}
}
