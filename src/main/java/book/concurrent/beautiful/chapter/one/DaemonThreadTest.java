package book.concurrent.beautiful.chapter.one;

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread userThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {

                }
            }
        });

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {

                }
            }
        });

        daemonThread.setDaemon(Boolean.TRUE);


        userThread.start();
        daemonThread.start();
        System.out.println("main over");

    }
}
