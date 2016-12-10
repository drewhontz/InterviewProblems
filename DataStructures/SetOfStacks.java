import java.util.Stack;
import java.util.EmptyStackException;
import java.util.ArrayList;

public class SetOfStacks {
private int sizeCurrent;
private int stackIndex;
private int limit;
private ArrayList<Stack<Integer> > data;

public SetOfStacks() {
        sizeCurrent = 0;
        stackIndex = 0;
        limit = 0;
        data = new ArrayList<Stack<Integer> >();
}

public SetOfStacks(int limit){
        sizeCurrent = 0;
        stackIndex = 0;
        limit = limit;
        data = new ArrayList<Stack<Integer> >();
}

public int push(int n){
        if (data.get(stackIndex).size() == limit) {
                stackIndex+=1;
                data.add(new Stack<Integer>());
        }
        data.get(stackIndex).push(n);
        return data.get(stackIndex).peek();
}

public int pop(){
        if (data.get(stackIndex).isEmpty() && stackIndex == 0) {
                throw new EmptyStackException();
        }
        int ret = data.get(stackIndex).pop();
        if (data.get(stackIndex).isEmpty()) {
                data.remove(stackIndex);
                stackIndex-=1;
        }
        return data.get(stackIndex).pop();
}
}
