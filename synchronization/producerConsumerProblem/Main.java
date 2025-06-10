package synchronization.producerConsumerProblem;

public class Main {
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource(3);
        Thread producerThread = new Thread(() -> {
            for(int i = 0; i <= 6; i++){
                sharedResource.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i = 0; i <= 6; i++){
                sharedResource.consume();
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
