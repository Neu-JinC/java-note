package book.concurrent.beautiful.chapter.one;

public class InheritableThreadLocalTest {
    public static ThreadLocal threadLocal = new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("main Local Test");
        System.out.println("main thread: " + threadLocal.get());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("subThread: " + threadLocal.get());
            }
        });

        thread.start();

        thread.join();
    }
}
