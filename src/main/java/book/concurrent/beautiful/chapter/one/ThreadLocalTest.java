package book.concurrent.beautiful.chapter.one;

public class ThreadLocalTest {
    private static ThreadLocal<String> localVariable = new ThreadLocal<String>();
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    public static void print() {
        System.out.println(Thread.currentThread().getName() + ": " + localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print();
                System.out.println("threadOne remove after: " + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print();
                System.out.println("ThreadTwo remove after: " + localVariable.get());
            }
        });

        threadOne.setName("threadOne");
        threadTwo.setName("threadTwo");

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("main over");
    }
}
