package book.jvm.chapter.four;

public class DeadLockMonitorTest implements Runnable{
    int a, b ;

    public  DeadLockMonitorTest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a  + b);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 100; i++) {
            new Thread(new DeadLockMonitorTest(1, 2)).start();
            new Thread(new DeadLockMonitorTest(2, 1)).start();
        }
        Thread.sleep(100);
    }
}
