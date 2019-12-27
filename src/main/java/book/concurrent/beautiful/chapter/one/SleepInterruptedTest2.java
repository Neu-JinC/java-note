package book.concurrent.beautiful.chapter.one;

public class SleepInterruptedTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().interrupted()) {

                }
                System.out.println("threadOne isInterrupted :" + Thread.currentThread().isInterrupted());
            }
        });

        //启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();

        threadOne.join();
        System.out.println("main oveer");
    }
}
