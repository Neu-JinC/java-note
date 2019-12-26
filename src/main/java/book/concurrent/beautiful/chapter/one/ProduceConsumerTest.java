package book.concurrent.beautiful.chapter.one;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

public class ProduceConsumerTest {
    public static volatile List<String> queue = new ArrayList<>();
    public static volatile Integer MAX_VALUE = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread produceAThread = new Thread(new Produce());
        Thread produceBThread = new Thread(new Produce());

        Thread consumerAThread = new Thread(new Consumer());
        Thread consumerBThread = new Thread(new Consumer());
        Thread consumerCThread = new Thread(new Consumer());
        produceAThread.setName("produceA");
        produceBThread.setName("produceB");
        consumerAThread.setName("consumerA");
        consumerBThread.setName("consumerB");
        consumerCThread.setName("consumerC");

        produceAThread.start();
        produceBThread.start();
        consumerAThread.start();
        consumerBThread.start();
//        consumerCThread.start();

        Thread.sleep(10);
        produceAThread.interrupt();
        produceBThread.interrupt();

        produceAThread.join();
        produceBThread.join();
        consumerAThread.join();
        consumerBThread.join();
    }
}

class Produce implements Runnable {
    @Override
    public void run() {
        synchronized (ProduceConsumerTest.queue) {
            while (Boolean.TRUE) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }


    private  void produce() throws InterruptedException{
        System.out.println("Produce thread begin, threadName:" + Thread.currentThread().getName());
        while (ProduceConsumerTest.queue.size() == ProduceConsumerTest.MAX_VALUE) {
            try {
                System.out.println("produce thread:" + Thread.currentThread().getName() + " wait");
                ProduceConsumerTest.queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            produceValue();
            ProduceConsumerTest.queue.notifyAll();
            ProduceConsumerTest.queue.wait();
            System.out.println("Produce thread wait, thread name: " + Thread.currentThread().getName());
    }

    public static void produceValue() {
        ProduceConsumerTest.queue.add(Thread.currentThread().getName());
        System.out.println("produce value:" + Thread.currentThread().getName() + ", size: " + ProduceConsumerTest.queue.size());

    }
}

class Consumer implements Runnable {
    @Override
    public void run() {
        synchronized (ProduceConsumerTest.queue) {
            while (Boolean.TRUE) {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public void consumer() throws InterruptedException {
        System.out.println("Consumer thread begin, threadName:" + Thread.currentThread().getName());

        while (ProduceConsumerTest.queue.size() == 0) {
            try {
                System.out.println("consumer thread:" + Thread.currentThread().getName() + " wait");
                ProduceConsumerTest.queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


            consumerValue();
            ProduceConsumerTest.queue.notifyAll();
            ProduceConsumerTest.queue.wait();
            System.out.println("Consumer thread wait, thread name: " + Thread.currentThread().getName());
    }

    public  void consumerValue() {
        String value = ProduceConsumerTest.queue.remove(ProduceConsumerTest.queue.size()-1);
        System.out.println("consumer value:" + value + ", size: " + ProduceConsumerTest.queue.size());
    }
}
