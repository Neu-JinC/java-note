package book.jvm.chapter.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTraceTest {
    public int add (int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest bTraceTest = new BTraceTest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int index = 0; index < 10; index ++) {
            String str = bufferedReader.readLine();
            System.out.println(str);
            int a = (int)Math.round(Math.random() * 1000);
            int b = (int)Math.round(Math.random() * 1000);

            System.out.println(bTraceTest.add(a, b));

        }
    }
}
