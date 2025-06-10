package synchronization.producerConsumerProblem;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) {
        try{
            if(bufferSize == sharedBuffer.size()){
                System.out.println("Buffer is full , waiting for consumer");
                wait();
            }
        }
        catch (Exception ex){
            System.out.println("An Exception has occured in producer  : " + ex.getMessage());
        }
        sharedBuffer.add(item);
        System.out.println("Produced : " + item);
        notify();
    }

    public synchronized void consume(){
        try{
            if(sharedBuffer.isEmpty()){
                System.out.println("Buffer is Empty , waiting for producer");
                wait();
            }
        }
        catch (Exception ex){
            System.out.println("An Exception has occured in consumer : " + ex.getMessage());
        }
        int item = sharedBuffer.poll();
        System.out.println("consumed : " + item);
        notify();
    }
}
