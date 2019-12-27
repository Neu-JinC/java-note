package book.concurrent.beautiful.chapter.one;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class SleepInterruptedTest {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {

                }
            }
        });

        threadOne.start();

        threadOne.interrupt();
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        System.out.println("isInterrupted: " + threadOne.interrupted());
        System.out.println("isInterrupted: " + threadOne.isInterrupted());

        System.out.println("isInterrupted: " + Thread.interrupted());
        System.out.println("isInterrupted: "  + threadOne.isInterrupted());

    }
}
