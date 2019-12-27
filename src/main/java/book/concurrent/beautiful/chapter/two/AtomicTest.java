package book.concurrent.beautiful.chapter.two;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 9, 0};
    private static Integer[] arrayTwo = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 9, 0};

    public static void main(String[] args) throws InterruptedException{
        Thread theadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int index = 0; index < arrayOne.length; index++) {
                    if(arrayOne[index] == 0) {
                        atomicInteger.incrementAndGet();
                    }
                }
            }
        });

        Thread theadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int index = 0; index < arrayTwo.length; index++) {
                    if(arrayTwo[index] == 0) {
                        atomicInteger.incrementAndGet();
                    }
                }
            }
        });

        theadOne.start();
        theadTwo.start();

        theadOne.join();
        theadTwo.join();

        System.out.println("atomicInteger: " + atomicInteger.get());
    }

}
