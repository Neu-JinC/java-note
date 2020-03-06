package job.written.examination;

public class LazyLoadTest {



    public static void main(String[] args) throws InterruptedException{
        for (Integer index = 0; index < 10; index++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LazyClass lazyLoadTest = LazyClass.getInstance();
                    System.out.println(lazyLoadTest);
                }
            });

            thread.start();
        }

        Thread.currentThread().sleep(1000);
    }
}

class LazyClass {
    private static LazyClass lazyLoad;

    private LazyClass() {

    }

    public static LazyClass getInstance() {
        if(lazyLoad == null) {
            synchronized("1") {
                if(lazyLoad == null) {
                    lazyLoad = new LazyClass();
                }
            }
        }

        return lazyLoad;
    }
}


