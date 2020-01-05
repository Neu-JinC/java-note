package book.jvm.chapter.four;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JConsoleTest {

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = Lists.newArrayList();
        for(int index = 0; index < num; index++) {
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        fillHeap(1000);
        bufferedReader.readLine();
        System.gc();
    }
}

class OOMObject {
    public byte[] placeHolder = new byte[4 * 1024];
}