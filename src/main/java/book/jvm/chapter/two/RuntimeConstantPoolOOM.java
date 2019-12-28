package book.jvm.chapter.two;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * VM args: -XX: PermSize=10M -XX:MaxPermSize=10M
 * 常量池溢出测试
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        Integer index = 0;
        while (Boolean.TRUE) {
            list.add(String.valueOf(index++).intern());
        }
    }
}
