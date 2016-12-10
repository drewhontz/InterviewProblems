// Feedback : How do you remove from an array? Watch your code more closely. Use more pseudocode in walkthrough

import java.lang.UnsupportedOperationException;
import java.util.EmptyStackException;

public class ThreeInOne {
private int[] startIndex = new int[3];  // Convenience array for keeping track of where each stack begins
private int[] currentIndex = new int[3]; // Convenience array for keeping track of where next push will happen
private int[] data; // Array storing all of our stack data
private int size;
// Returns a new ThreeInOne object with each individual stack of size 'size'
public ThreeInOne(int size){
        // Assumes size is an Integer > 1
        if (size < 1) throw new UnsupportedOperationException();
        size = size;
        data = new int[size * 3];
        startIndex = new int[] {0, size, size*2};
}

public ThreeInOne(){
        size = 5;
        data = new int[size * 3]; //Default stack size of 5
        startIndex = new int[] {0,size,size*2};
}

// Index specifies which stack you wish to push on i.e. 0,1,2
public int push(int index, int value){
        if (currentIndex[index] == size * index + 1) {
                this.resize();  // resize implementation TBD
        }
        data[currentIndex[index]] = value;
        currentIndex[index] += 1;
        return data[currentIndex[index]];
}

public int pop(int index){
        if (currentIndex[index] == startIndex[index]) {
                throw new EmptyStackException();
        }
        int value = data[currentIndex[index] - 1];
        currentIndex[index]-=1;
        return value;
}

public void resize(){
        // TODOs
}

public boolean empty(int index){
        return currentIndex[index] == startIndex[index];
}

public int size(int index){
        return currentIndex[index] - startIndex[index];
}
}
