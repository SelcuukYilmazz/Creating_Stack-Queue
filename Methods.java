//package assignment4;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Methods {
    Stack1 stack2 = new Stack1();
    Stack1 stack3 = new Stack1();
    Stack1 stack4 = new Stack1();

    Queue1 queue2 = new Queue1();
    Queue1 queue3 = new Queue1();
    Queue1 queue4 = new Queue1();

    Random random = new Random();

// We remove great numbers from stacks in here
// We use stacks pop ability to remove greater numbers from them and use push ability to add new elements to them

    public void removeGNumberS(int numbers,Stack1 stack1) throws IOException {
        int element1;
        int i;
        i = 0;
        while(i<stack1.getsize()){
            element1 = stack1.pop();
            if (element1<=numbers){
                stack2.push(element1);
            }
        }
        i = 0;
        while(i<stack2.getsize()){
            element1 = stack2.pop();
            stack1.push(element1);
        }
        stack1.stackFile();
    }

//    We calculate stack distance in here
//    We use stacks pop ability to take items and use push ability to not change them

    public int distanceS(Stack1 stack1){
        int i;
        int k;
        int j;
        int result = 0;
        int element1;
        int element2;
        i = 0;
        while(i<stack1.getsize()){

            element1 = stack1.pop();
            stack2.push(element1);

            k = 0;
            while(k<stack1.getsize()){
                element1 = stack1.pop();
                stack3.push(element1);
                if (stack2.getsize()>0){
                    element2 = stack2.peek();
                    result = Math.abs(element2-element1)+Math.abs(result);
                }
            }

            j = 0;
            while(j<stack3.getsize()){
                stack1.push(stack3.pop());
            }
        }
        i=0;
        while(i<stack2.getsize()){
            stack1.push(stack2.pop());
        }
        return result;
    }

//    We add or remove to stack from here
//    We use stacks pop ability to remove elements from them and push ability to add new elements to them

    public void addOrRemoveElementsS(int numbers,Stack1 stack1) throws IOException {
        int i;
        i = 0;
        if(numbers>0){
            while(i<stack1.getsize()){
                stack2.push(stack1.pop());
            }
            i=0;
            while(i<numbers){
                i++;
                stack1.push(random.nextInt(50));
            }
            i=0;
            while (i<stack2.getsize()){
                stack1.push(stack2.pop());
            }
        }

        i = 0;
        if(numbers<0){
            while(i<stack1.getsize()+numbers){
                stack2.push(stack1.pop());
            }
            i=0;
            while(i>numbers){
                i--;
                stack1.pop();
            }
            i=0;
            while (i<stack2.getsize()){
                stack1.push(stack2.pop());
            }
        }
        stack1.stackFile();
    }

//    We reverse stack elements in here
//    We use queues enqueue and dequeue ability with stacks pop and push ability to make stacks reverse

    public void reverseS(Stack1 stack1,int numbers) throws IOException {
        int i;
        i = 0;
        while(i<stack1.getsize()-numbers){
            stack2.push(stack1.pop());
        }
        i=0;
        while (i<numbers){
            i++;
            queue4.queueEnqueue(stack1.pop());
        }
        i=0;
        while (i<queue4.getsize()){
            stack1.push(queue4.queueDequeue());
        }
        i=0;
        while(i<stack2.getsize()){
            stack1.push(stack2.pop());
        }
        stack1.stackFile();
    }

//    We sort stack elements in here
//    We use multiple stacks here for sort them and reverse them for the right order

    public void sortElementsS( Stack1 stack1) throws IOException {
        int i;
        int k;
        int element1;
        int element2;
        i = 0;
        while(i<stack1.getsize()){

            element1 = stack1.pop();

            k = 0;
            while(k<stack1.getsize()){
                element2 = stack1.pop();
                stack2.push(element2);
                if (element1>element2){
                    stack2.pop();
                    stack2.push(element1);
                    element1 = element2;
                }
            }
            stack3.push(element1);
            k = 0;
            while(k<stack2.getsize()){
                stack1.push(stack2.pop());
            }
        }
        i = 0;
        while(i<stack3.getsize()){
            stack1.push(stack3.pop());
        }
        reverseS(stack1,stack1.getsize());
        stack1.stackFile();
    }

//    We calculate distinct elements of stacks here
//    We use multiple stacks and sort method for the make our job little bit easier then we look for different elements.
//    It is easier because of the sort method.Because now our same elements next to each other we can say the difference easier.

    public int distinctElementsS( Stack1 stack1) throws IOException {
        int i;
        int element1;
        int element2;
        int distinctElements = stack1.getsize();
        i = 0;
        while(i<stack1.getsize()){
            element1 = stack1.pop();
            stack4.push(element1);
            stack3.push(element1);
        }
        i = 0;
        while (i<stack3.getsize()){
            stack1.push(stack3.pop());
        }
        sortElementsS(stack4);
        i = 0;
        while(i<stack4.getsize()){

            element1 = stack4.pop();
            if (!stack4.isEmpty()){
                element2 = stack4.peek();
                if(element1 == element2){
                    distinctElements= distinctElements - 1;
                }
            }
        }
        return distinctElements;
    }

//    We remove great number elements in queue here
//    We use queue's dequeue ability to erase items.

    public void removeGNumberQ(int numbers,Queue1 queue1) throws IOException {
        int element1;
        int i;
        i = 0;
        while(i<queue1.getsize()){
            element1 = queue1.queueDequeue();
            if (element1<=numbers){
                queue2.queueEnqueue(element1);
            }
        }
        i = 0;
        while(i<queue2.getsize()){
            element1 = queue2.queueDequeue();
            queue1.queueEnqueue(element1);
        }
        queue1.queueFile();
    }

//    We calculate distance elements of queue here.
//    We use multiple queues here for make the algorithm and calculate distance.

    public int distanceQ(Queue1 queue1){
        int i;
        int k;
        int j;
        int result = 0;
        int element1;
        int element2;
        i = 0;
        while(i<queue1.getsize()){

            element1 = queue1.queueDequeue();
            queue2.queueEnqueue(element1);

            k = 0;
            while(k<queue1.getsize()){
                element1 = queue1.queueDequeue();
                queue3.queueEnqueue(element1);
                if (queue2.getsize()>0){
                    element2 = queue2.queuePeekLast();
                    result = Math.abs(element2-element1)+Math.abs(result);
                }
            }

            j = 0;
            while(j<queue3.getsize()){
                queue1.queueEnqueue(queue3.queueDequeue());
            }
        }
        i=0;
        while(i<queue2.getsize()){
            queue1.queueEnqueue(queue2.queueDequeue());
        }
        return result;
    }

//    We add or remove elements to queue here
//    We use enqueue ability to add elements and dequeue ability to remove elements

    public void addOrRemoveElementsQ(int numbers,Queue1 queue1) throws IOException {
        int i;
        i = 0;
        if(numbers>0){
            while(i<numbers){
                i++;
                queue1.queueEnqueue(random.nextInt(50));
            }
        }

        i = 0;
        if(numbers<0){
            while(i>numbers){
                i--;
                queue1.queueDequeue();
            }
        }
        queue1.queueFile();
    }

//    We reverse queue here
//    We stacks with queues here for make our job little bit easier
//    Because if we use both ability together datas automatically reverse

    public void reverseQ(Queue1 queue1,int numbers) throws IOException {
        int i;
        int element1;
        i = 0;
        while(i<numbers){
            i++;
            element1 = queue1.queueDequeue();
            stack4.push(element1);
        }
        i=0;
        while (i<queue1.getsize()){
            queue2.queueEnqueue(queue1.queueDequeue());
        }
        i=0;
        while (i<stack4.getsize()){
            queue1.queueEnqueue(stack4.pop());
        }
        i=0;
        while(i<queue2.getsize()){
            queue1.queueEnqueue(queue2.queueDequeue());
        }
        queue1.queueFile();
    }

//    We sort queue elements here
//    In stack sort method it was working so we change all datas from queue to stack and then we store them on queue for sorting

    public void sortElementsQ ( Queue1 queue1) throws IOException {
        int i;
        int k;
        int element1;
        int element2;
        i = 0;
        while(i<queue1.getsize()){
            stack4.push(queue1.queueDequeue());
        }
        i = 0;
        while(i<stack4.getsize()){

            element1 = stack4.pop();

            k = 0;
            while(k<stack4.getsize()){
                element2 = stack4.pop();
                stack2.push(element2);
                if (element1>element2){
                    stack2.pop();
                    stack2.push(element1);
                    element1 = element2;
                }
            }
            stack3.push(element1);
            k = 0;
            while(k<stack2.getsize()){
                stack4.push(stack2.pop());
            }
        }
        i = 0;
        while(i<stack3.getsize()){
            stack4.push(stack3.pop());
        }
        i = 0;
        while (i<stack4.getsize()){
            queue1.queueEnqueue(stack4.pop());
        }
        queue1.queueFile();
    }

//    We calculate distinct elements of queue here
//    First we sort elements to make our job easier then we use multiple queues together

    public int distinctElementsQ( Queue1 queue1) throws IOException {
        int i;
        int element1;
        int element2;
        int distinctElements = queue1.getsize();
        i = 0;
        while(i<queue1.getsize()){
            element1 = queue1.queueDequeue();
            queue4.queueEnqueue(element1);
            queue3.queueEnqueue(element1);
        }
        i = 0;
        while (i<queue3.getsize()){
            queue1.queueEnqueue(queue3.queueDequeue());
        }
        sortElementsQ(queue4);
        i = 0;
        while(i<queue4.getsize()){
            
            element1 = queue4.queueDequeue();
            if (!queue4.isEmpty()){
                element2 = queue4.queuePeekFirst();
                if(element1 == element2){
                    distinctElements= distinctElements - 1;
                }
            }
        }
        return distinctElements;
    }
}
