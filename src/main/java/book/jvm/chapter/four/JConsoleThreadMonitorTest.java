package book.jvm.chapter.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JConsoleThreadMonitorTest {
    public static void createBusyThread() {
        Thread busyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("testBusyThread run");
                while (Boolean.TRUE) {

                }
            }
        }, "testBusyThread");

        busyThread.start();
    }

    public static void createLockThread(final Object resource) {
        Thread lockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("testLockThread run");
                synchronized (resource) {
                    try {

                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();;
                    }
                }
            }
        }, "testLockThread");
        lockThread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        createLockThread(new Object());
    }
}
