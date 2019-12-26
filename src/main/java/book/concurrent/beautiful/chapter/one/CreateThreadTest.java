package book.concurrent.beautiful.chapter.one;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的几种方式
 */
public class CreateThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();

        ImplRunable implRunable = new ImplRunable();
        Thread implRunableThread = new Thread(implRunable);
        implRunableThread.start();

        ImplCallable implCallable= new ImplCallable();
        FutureTask<String> futureTask = new FutureTask<String>(implCallable);
        Thread implCallableThread = new Thread(futureTask);
        implCallableThread.start();
        String result = futureTask.get();
        System.out.println("futureTask result: " + result);

        implRunableThread.join();
        extendsThread.join();
        System.out.println("main over");
    }
}

class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am extend Thread");
    }
}

class ImplRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("I am impl Runnable");
    }
}

class ImplCallable implements Callable<String> {
    @Override
    public String  call() throws Exception {
        System.out.println("I am impl callable");
        return "I am impl callable";
    }
}