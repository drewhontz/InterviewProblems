public class BitManipulation {

public static int clearBit(int index, int num){
        return num ^ (1 << index);
}

public static int setBit(int index, int num){
        return num | (1 << index);
}
}
