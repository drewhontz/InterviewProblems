
public class BitManipulation {

	public static void main(String[] args) {
		int n = 0b10000000000;
		int m = 0b10011;
		int value = insert(n, m, 2, 6);
		
		System.out.println(Integer.toBinaryString(value));
		int res = decToInt(72);
		System.out.print(res);			
	}
	
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	public static int insert(int n, int m, int i, int j){
		//32 bit int of 1s
		int ones = ~0;
		//shift 1s from start to j ex: 1110000
		int left = ones << (j+1);
		//shift 1s from end to i ex 000011
		int right = ((1<<i) - 1);
		//create n mask with a 0s gap for m to be &nd
		int mask = left | right;
		//N with cleared interval i --> j
		int clearN = n & mask;
		//shift m i to the left
		int m_shift = m << i;
		//throw m values into n
		return clearN | m_shift;
	}
	//fix dis
	public static int decToInt(int p){
		int result = 0b00000000000000000000000000000000;
		for (int i = 32; p > 0; i--){
			if (Math.pow(2, i) <= p){
				setBit(result, i);
				p = p - result;
			}
		}
		return result;
	}
	
	public static int setBit(int num, int i){
		return (num | (1 << i));
	}
	
	public static int clearBit(int num, int i){
		int mask =  ~(num & 1 << i) ;
		return (mask & num);	
	}
	
	public static int clearFrontToI(int num, int i){
		int mask = (1 << i) - 1;
		return (num & mask);
	}
	
//	public int clearToI(int num, int i){
//		int mask = (0 >> i);
//	}
	
	public static int updateBit(int num, int i, int value){
		int mask = ~(1 << i);
		return (num & mask) | (value << i);
	}

}
