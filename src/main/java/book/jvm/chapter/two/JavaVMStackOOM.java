package book.jvm.chapter.two;

/**
 * VM Args: -Xss2M
 * stack溢出测试
 */
public class JavaVMStackOOM {
    private  void doStop() {
        while (true) {

        }
    }

    private  void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    doStop();
                }
            });

            thread.run();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }

}
