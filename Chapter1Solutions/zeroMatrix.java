
public class zeroMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = {{1,10,1},{2,2,2},{3,0,3},{4,4,4}};

		printMatrix(t);
		System.out.println("\n\n");
		printMatrix(zeroMatrixFunc(t));
	}
	
	public static int[][] zeroMatrixFunc(int[][] m){
		boolean[] rowHasZero = new boolean[m[0].length];
		boolean[] columnHasZero = new boolean[m.length];
		
		//Scan thru matrix looking for zeroes
		for (int row = 0; row < rowHasZero.length; row++){
			for (int col = 0; col < columnHasZero.length; col++){
				if (m[col][row] == 0){
					rowHasZero[row] = true;
					columnHasZero[col] = true;
				}
			}
		}
		
		//Nullify them rows with zeros
		for (int i = 0; i < rowHasZero.length; i++){
			if (rowHasZero[i]){
				nullifyRow(m, i);
			}
		}
		
		//Nullify them columns with zeroes
		for (int i = 0; i < columnHasZero.length; i++){
			if (columnHasZero[i]){
				nullifyColumn(m, i);
			}
		}		
		return m;
	}

	public static void nullifyRow(int[][] m, int n){
		for (int i = 0; i < m.length; i++){
			m[i][n] = 0;
		}
	}
	
	public static void nullifyColumn(int[][] m, int n){
		for (int i = 0; i < m[0].length; i++){
			m[n][i] = 0;
		}
	}
	
	public static void printMatrix(int[][] m){
		int r = m[0].length;
		int c = m.length;
		for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
				System.out.printf("|%d|",m[j][i]);
			}
			System.out.println('\n');
		}
	}
}
