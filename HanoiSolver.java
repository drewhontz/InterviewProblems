/*
   Clarify

   Inputs - N where n is the number of disks from 0 - N; Output is number of
   moves required to solve?

   TestCase

   Brainstorm

   RA
 */

import java.util.Stack;


public class HanoiSolver {

public void main(String[] args){
        int n = 9;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
                towers[i] = new Tower(i);
        }

        for (int i = n - 1; i >= 0; i-=1) {
                towers[0].add(i);
        }

        towers[0].move(n, towers[2], towers[1]);
}

private class Tower {

private int index;
private Stack<Integer> disks;

public Tower(int i){
        disks = new Stack<Integer>();
        index = i;
}

public void add(int n){
        if (disks.peek() < n && !disks.isEmpty()) {
                System.out.println("Move forbidden");
        } else {
                disks.push(n);
        }
}

public void moveTop(Tower dest){
        int t = disks.pop();
        dest.add(t);
}

public void move(int disk, Tower dest, Tower via){
        if (disk > 0) {
                move(disk - 1, via, dest);
                moveTop(dest);
                via.move(disk - 1, dest, this);
        }
}
}
}
