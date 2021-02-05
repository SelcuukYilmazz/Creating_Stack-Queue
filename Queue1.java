//package assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Queue1 {
    ArrayList<Integer> queuelist1 = new ArrayList<Integer>();

    //    We add elements from last index here

    public void queueEnqueue(int numbers)
    {
            queuelist1.add(numbers);
    }

    //    We calculate is Queue empty or not

    public boolean isEmpty() {
        if (queuelist1.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    //    We remove and use first elements of queue here

    public int queueDequeue()
    {
        int queueValue = queuelist1.get(0);
        queuelist1.remove(0);
        return queueValue;
    }

    //    We display queue here

    public void queueDisplay() throws IOException {
        FileWriter fileWriter = new FileWriter("queueOut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int i;
        for (i = 0; i < queuelist1.size(); i++) {
            printWriter.print(queuelist1.get(i)+" ");
        }
       printWriter.print("\n");
       printWriter.close();
        return;
    }

    //    We can see and use last item of queue here

    public int queuePeekLast()
    {
        return queuelist1.get(queuelist1.size()-1);
    }

    //    We see and use first item of queue here

    public int queuePeekFirst()
    {
        return queuelist1.get(0);
    }

    //  We can see Queue size here

    public int getsize(){
        return queuelist1.size();
    }

    //    We write queue.txt file here

    public void queueFile() throws IOException {
        FileWriter fileWriter = new FileWriter("queue.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int i;
        for (i = 0; i < queuelist1.size(); i++) {
            printWriter.print(queuelist1.get(i)+" ");
        }
        printWriter.print("\n");
        printWriter.close();
        return;
    }
}
