package book.concurrent.beautiful.chapter.one;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DeadLockTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne waiting get resourceA...");
                synchronized (resourceA) {
                    System.out.println("threadOne get resourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("threadOne get resourceA, waiting get resourceB...");
                    synchronized (resourceB) {
                        System.out.println("threadOne get resourceB");
                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadTwo waiting get resourceB...");
                synchronized (resourceB) {
                    System.out.println("threadTwo get resourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("threadTwo get resourceB, waiting get resourceA...");
                    synchronized (resourceA) {
                        System.out.println("threadTwo get resourceA");
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("main over!");
    }
}
