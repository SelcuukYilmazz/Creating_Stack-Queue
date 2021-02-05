//package assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
    Methods methods = new Methods();
    public Writer() throws IOException {
    }

//    We write Stack methods who are taking number parameter here

    public void StackWriterNumber(String key,int numbers,Stack1 stack1) throws IOException {
        FileWriter fileWriter = new FileWriter("stackOut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        switch (key){
            case "removeGreater":
                methods.removeGNumberS(numbers,stack1);
                printWriter.print("After removeGreater "+numbers+":\n");
                printWriter.close();
                stack1.stackDisplay();

                break;
            case "addOrRemove":
                methods.addOrRemoveElementsS(numbers,stack1);

                printWriter.println("After addOrRemove "+numbers+":");
                printWriter.close();
                stack1.stackDisplay();
                break;
            case "reverse":
                methods.reverseS(stack1,numbers);
                printWriter.print("After reverse "+numbers+":\n");
                printWriter.close();
                stack1.stackDisplay();
                break;
        }
    }

//    We write Stack methods who are not take number parameter here

    public void StackWriter(String key,Stack1 stack1) throws IOException {
        FileWriter fileWriter = new FileWriter("stackOut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        switch (key){
            case "calculateDistance":
                printWriter.print("After calculateDistance: \n" +
                        "Total distance="+methods.distanceS(stack1)+"\n");
                printWriter.close();
                break;
            case "sortElements":
                methods.sortElementsS(stack1);
                printWriter.println("After sortElements:");
                printWriter.close();
                stack1.stackDisplay();
                break;
            case "distinctElements":
                printWriter.print("After distinctElements:\n" +
                        "Total distinct element="+methods.distinctElementsS(stack1)+"\n");
                printWriter.close();
                break;
        }
    }

//    We write queue methods who are taking number parameter

    public void QueueWriterNumber(String key,int numbers,Queue1 queue1) throws IOException {
        FileWriter fileWriter = new FileWriter("queueOut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        switch (key){
            case "removeGreater":
                methods.removeGNumberQ(numbers,queue1);
                printWriter.print("After removeGreater "+numbers+":\n");
                printWriter.close();
                queue1.queueDisplay();
                break;
            case "addOrRemove":
                methods.addOrRemoveElementsQ(numbers,queue1);
                printWriter.println("After addOrRemove "+numbers+":");
                printWriter.close();
                queue1.queueDisplay();
                break;
            case "reverse":
                methods.reverseQ(queue1,numbers);
                printWriter.print("After reverse "+numbers+":\n");
                printWriter.close();
                queue1.queueDisplay();
                break;
        }
    }

//    We write queue methods who are not takin number parameter


    public void QueueWriter(String key,Queue1 queue1) throws IOException {
        FileWriter fileWriter = new FileWriter("queueOut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        switch (key){
            case "calculateDistance":
                printWriter.print("After calculateDistance: \n" +
                        "Total distance="+methods.distanceQ(queue1)+"\n");
                printWriter.close();

                break;
            case "sortElements":
                methods.sortElementsQ(queue1);
                printWriter.println("After sortElements: ");
                printWriter.close();
                queue1.queueDisplay();
                break;
            case "distinctElements":
                printWriter.print("After distinctElements:\n" +
                        "Total distinct element="+methods.distinctElementsQ(queue1)+"\n");
                printWriter.close();
                break;
        }
    }
}
