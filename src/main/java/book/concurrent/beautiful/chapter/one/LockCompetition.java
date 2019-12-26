package book.concurrent.beautiful.chapter.one;

/**
 * 锁释放仅释放自己，不会释放其他锁
 */
public class LockCompetition {
    private volatile static Object resourceA = new Object();
    private volatile static  Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");

                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("threadB try get resourceA lock");
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");

                        System.out.println("threadB try get resourceB lock");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");

                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("main thread over");
    }
}
