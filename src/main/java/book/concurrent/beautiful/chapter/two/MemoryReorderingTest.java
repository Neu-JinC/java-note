package book.concurrent.beautiful.chapter.two;

/**
 * 指令重排序问题
 */
public class MemoryReorderingTest {
    protected static Integer num = 0;
    protected static Boolean ready = Boolean.FALSE;

    public static void main(String[] args) throws InterruptedException{
        ReaderThread readerThread = new ReaderThread();
        WriterThread writerThread = new WriterThread();

        readerThread.start();

        writerThread.start();

        Thread.sleep(10);
        readerThread.interrupt();
        readerThread.join();
        System.out.println("main over");
    }


}

class ReaderThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if(MemoryReorderingTest.ready) {
                System.out.println("num + num = " + (MemoryReorderingTest.num + MemoryReorderingTest.num));
            }

            System.out.println("read thread...");
        }
    }
}

class WriterThread extends Thread {
    @Override
    public void run() {
        MemoryReorderingTest.num = 2;
        MemoryReorderingTest.ready = Boolean.TRUE;
        System.out.println("writer thread over...");
    }
}