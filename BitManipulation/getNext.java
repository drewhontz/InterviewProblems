public class getNext {
public static void main(String[] args){
        System.out.println(getPrev(Integer.parseInt(args[0])));
        System.out.println(getNext(Integer.parseInt(args[0])));
}

public static int getNext(int num){
        // Compute countZeroes, the number of zeros right of index p
        int c = num;
        int countZeroes = 0;
        int countOnes = 0;
        while(((c & 1) == 0) && c != 0) {
                countZeroes++;
                c >>= 1;
        }
        // Compute countOnes, the number of ones right of index p
        while(((c & 1) == 1) && c != 0) {
                countOnes++;
                c >>= 1;
        }
        int p = countZeroes + countOnes;
        if (p == 31 || p == 0) return -1;

        // Flip rightmost trailing 0
        num |= (1 << p);
        // Clear bits right of p
        num &= ~((1 << p) - 1);
        // Insert (c1 -1) ones on the right
        num |= (1 << (countOnes - 1)) - 1;
        return num;
}

public static int getPrev(int num){
        // Compute countZeroes, the number of zeros right of index p
        int c = num;
        int countZeroes = 0;
        int countOnes = 0;

        while((c & 1) == 1) {
                countOnes++;
                c >>= 1;
        }

        while(((c & 1) == 0) && c != 0) {
                countZeroes++;
                c >>= 1;
        }

        int p = countZeroes + countOnes;
        if (p == 31 || p == 0) return -1;

        // clear bits len -> p
        num &= ((~0) << (p + 1));

        int mask = (1 << (countOnes + 1)) - 1;
        num |= mask << (countZeroes -1);
        // or w mask of c1+1 ones
        return num;
}
}
