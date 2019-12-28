package book.jvm.chapter.two;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unSafe分配本机内存
 * VM Args: -Xmx:20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(Boolean.TRUE);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
