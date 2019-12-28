package book.jvm.chapter.two;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 堆溢出测试
 * VM Args: -Xss128k
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMObject> list = Lists.newArrayList();
        while (Boolean.TRUE) {
            list.add(new OOMObject());
        }
    }
}

class OOMObject {

}