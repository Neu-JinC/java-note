package book.jvm.chapter.three;


public class PretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[5 * _1MB];
        while (Boolean.TRUE) {

        }
    }

    public static void main(String[] args) {
        PretenureSizeThreshold.testPretenureSizeThreshold();
    }
}