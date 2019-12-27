package book.concurrent.beautiful.chapter.two;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Getter
public class UnSafeTest {
    private final static Unsafe unSafe;

    private static final Long stateOffset;

    private volatile Long state = 0L;

    static {
        try {
            //使用反射获取UnSafe类的theUnSafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            //设置未可存取
            field.setAccessible(Boolean.TRUE);

            //获取变量的值
            unSafe = (Unsafe) field.get(null);

            //获取sate在UnSafeTest的偏移量
            stateOffset = unSafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
            throw  new Error(e);
        }
    }

    public static void main(String[] args) {
        UnSafeTest unSafeTest = new UnSafeTest();
        Boolean success = unSafe.compareAndSwapObject(unSafeTest, stateOffset, unSafeTest.state, 1L);
        System.out.println(success);
        System.out.println(JSON.toJSONString(unSafeTest));
    }

}
