import java.util.Stack; // Not in LANG!!!

public class TowersOfHanoi {

public static void main(String[] args){
        Stack<Integer> s = new Stack[args[0]];
}

public void solver(int disks, Stack origin, Stack destination, Stack via){
        if (disks >= 1) {
                solver(disks - 1, origin, via, destination);
                move(disks, origin, destination);
                solver(disks - 1, via, destination, origin);
        }
}

public void move(int disk, Stack origin, Stack destination){
        destination.push(origin.pop());
}
}
