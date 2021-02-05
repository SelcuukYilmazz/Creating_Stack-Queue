//package assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Stack1 {
    ArrayList<Integer> stacklist1 = new ArrayList<Integer>();

//    We add numbers to Stacks from last index here

    public void push(int numbers){
        stacklist1.add(numbers);
    }

//    We check Stack is empty or not here

    public boolean isEmpty() {
        if (stacklist1.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

//    We use and delete last index of stack here

    public int pop(){
        int popValue = stacklist1.get(stacklist1.size() - 1);
        stacklist1.remove(stacklist1.size() - 1);
        return popValue;
    }

//    We see and use last index of stack here

    public int peek() {
            return stacklist1.get(stacklist1.size() - 1);
    }

//    We can see our stack size here

    public int getsize(){
        return stacklist1.size();
    }

//    We can write what is our stack here

    public void stackDisplay() throws IOException {
        FileWriter fileWriter = new FileWriter("stackOut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int i;
        for (i = 0; i < stacklist1.size(); i++) {

            printWriter.print( stacklist1.get(i)+" ");
        }
        printWriter.print("\n");
        printWriter.close();
        return;
    }

//    We change stack.txt here

    public void stackFile() throws IOException {
        FileWriter fileWriter = new FileWriter("stack.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int i;
        for (i = 0; i < stacklist1.size(); i++) {
            printWriter.print( stacklist1.get(i)+" ");
        }
        printWriter.print("\n");
        printWriter.close();
        return;
    }
}

